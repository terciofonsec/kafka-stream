package com.example.demo;

import com.example.demo.schema.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;


@Service
public class EmployeeProducer {

    private final Logger logger = LoggerFactory.getLogger(EmployeeProducer.class);
    private final StreamBridge streamBridge;

    public EmployeeProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produceEmployeeDetail(int empId, String firstName, String lastName){
        Employee employee = new Employee();
        employee.setId(empId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        logger.info("Sending employee event {} to kafka", employee);
       streamBridge.send("employees-out-0", employee);
    }
}
