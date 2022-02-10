/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minty.mintytest.controller;


import com.minty.mintytest.models.RequestPayload;
import com.minty.mintytest.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/techgeeknext-kafka/")
public class KafkaExampleController {

    @Autowired
    KafkaProducerService kafkaProducer;


    @PostMapping("/producer")
    public String sendMessage(@RequestBody RequestPayload request)
    {
        kafkaProducer.send(request);
        return "Message sent successfully to the Kafka topic techgeeknext-topic";
    }

}