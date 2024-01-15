package com.example.demo;

import com.example.demo.schema.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EmployeeConsumer {
    Logger logger = LoggerFactory.getLogger(EmployeeConsumer.class);
    @Bean
    public Consumer<Employee> employees() {
        return employee -> logger.info("Received employee! \"{}\" with name '{}' last name '{}'",
                employee.getId(), employee.getFirstName(), employee.getLastName());
    }
}
