# beneficiary

This project shows how to implement a basic microservice using spring-boot.

## What is this repository for?

* Implements beneficiary logic to save and read beneficiaries. 
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
* Run maven clean and install.

```bash
mvn clean install
```

## Who do I talk to?

* Repo owner or admin
    * [Fernando Ocampo](https://github.com/fernandoocampo)


