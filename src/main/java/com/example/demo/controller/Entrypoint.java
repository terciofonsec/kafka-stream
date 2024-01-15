package com.example.demo.controller;

import com.example.demo.EmployeeProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class Entrypoint {

    private final Logger logger = LoggerFactory.getLogger(Entrypoint.class);
    private final EmployeeProducer producer;
    public Entrypoint(EmployeeProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/echo")
    public ResponseEntity<String> echo(){
        return ResponseEntity.ok("It's working");
    }

    @PostMapping("/{id}/{firstName}/{lastName}")
    public void createEmployee(@PathVariable int id, @PathVariable String firstName,
                               @PathVariable String lastName){

        logger.info("Hey");

        producer.produceEmployeeDetail(id, firstName, lastName);

    }
}
