# beneficiary

This project shows how to implement a basic microservice using spring-boot. This branch contains a service that connects to a SAP HANA database in NEO SAP cloud.

## What is this repository for?

* Implements beneficiary logic to save and read beneficiaries. 
* Show how to deploy a spring-boot project in NEO sap cloud.
* Version: 0.1.0

## Service architecture

* This is a typical microservice implemented using Spring-boot.
* For this service we apply multi-layer pattern to struct and manage our code. With this strategy we promote loose coupling and high cohesion in our application, that leads to a flexible and extensible architecture.

## Service behavior

* After receiving a request from a service client, the controller request handler accepts the request, organize the input data, requests the service from the business logic layer, generates the data for response and responds to the client.
* Busines logic and rules are centralized into the business layer that serves as intermediary for data exchange between controller and the data access layer. Data is provided to the controller in the form of structs or value objects. Decoupling the controller handler from the business logic helps facilitate code reuse.
* Data access layer provides the interface with the data store tier and can be implemented using DAO design pattern. The benefit of this layer is in separating data access code from the business logic for disparate data store tecnologies. This layer can also act as an integration point to link with other systems, including being a client of other web service.

## Package naming convention

To accomplish the above architecture design, we propose the following convention for package namings.

```
+ [auth project]
    - controller/
    - /mediation/storage/
    - model/
    - service/
    - BeneficiaryApplication.java
    - README.md
```

| Package name  | Description                                                                  |
| ------------- | ---------------------------------------------------------------------------- |
| `controller/` | Contains implementation of our web technologies such as REST, graphql or RPC.|
| `/storage/`   | Code interfaces to define data access behavior and its implementations                   |
| `model/`      | Defines java classes that behaves as value objects and used in business logic. Here we define our static business layer represented in data models. |
| `service/`    | Defines the dynamic business layer, represented in behavior using functions or methods. Here we code interfaces and its implementations regarding our business logic.         |

## How do I get set up?

* Clone the project.

* You must configure the HANA database driver at your own.

    * Get the file ngdbc.jar
    * execute the following command in the same folder where you put the jar file.

    ```bash
    mvn install:install-file -Dfile=ngdbc.jar -DgroupId=com.sap.db -DartifactId=hana -Dversion=1.120.6 -Dpackaging=jar -DgeneratePom=true
    ```

### Development environment

* Run maven clean and install

```bash
mvn clean install
```

### Integration environment

* Run maven clean and install to build the project for integration environment.

```bash
mvn -Pint clean install
```

### SAP cloud Neo environment

* Run maven clean and install to build the project for integration environment.

```bash
mvn -Pneo clean install
```

* Go to [sap cloud trial](https://account.hanatrial.ondemand.com/)

* Log on with your account.

* Choose your region, right now I am using Home[Europe (Rot) - Trial]

* Create and use your subaccount.

* In the menu at the left select the option **SAP HANA / SAP ASE** .
    
    * Click on option **Databases & Schemas**.

* Press button [New]

    * Add a Database ID. For this project I gave the name: **beneficiarydb**
    * Give a password for SYSTEM user.
    * Enable Web Access.
    * Enable DP Server.

* Deploy your application

    * Give the **WAR File Location**. As we are using maven, search in the target folder.
    * Give an **Application Name**. I gave **beneficiary0**.
    * Select on **Runtime Name** the value **Java Web Tomcat 8**
    * Give on **Runtime Version** the value **2**.
    * Give on **Compute Unit Size** the valkue **Lite**.
    * Give on **Number of Processes** Min: and Max: the value 1 and 1 respectively.
    * Give on **JVM Version** the value **JRE 8**.
    * Give on **JVM Arguments** the value **-Dspring.profiles.active=neo**
    * Give on **Max Number of Threads** the default value **200**.
    * Give on **Connection Timeout (ms)** the default value **20000**.
    * Given on **URI Encoding** the default value **ISO-8859-1**.
    * Given on **Response Compression** the default value **Off**.
    * Press the button [**Deploy**] and wait...
    * ... After the deployment press [**Done**] button. Don't start the application yet.

* Create a **Data Source Binding**

    * Comeback to the database that you created in the beginning.
    * Select the database.
    * Select the option **Data Source Bindings** at the menu in the left.
    * Press the [**New Binding**] button.
    * Leave the default value in the **Data Source** field. <default>
    * Select the application that you created in the last point in the field **Java Application**.
    * In the **Custom Logon** section give the database user credentials. For this example I gave the SYSTEM ones :D .
    * Click on [**Save**] button.

* Comeback to your subaccount view and select the Java Applications menu.

    * I Select **beneficiary0**
    * Start the application.
 

## Who do I talk to?

* Repo owner or admin
    * [Fernando Ocampo](https://github.com/fernandoocampo)

## References

* [EclipseLink reference](http://www.eclipse.org/eclipselink/documentation/2.4/jpa/extensions/p_target_database.htm)


