package com.example.beneficiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Starts the Beneficiary service.
 *
 * @author fernando.ocampo
 */
@SpringBootApplication
public class BeneficiaryApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BeneficiaryApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BeneficiaryApplication.class, args);
    }
}
