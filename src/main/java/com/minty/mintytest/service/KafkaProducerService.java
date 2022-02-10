/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minty.mintytest.service;

/**
 *
 * @author Developer
 */

//import com.techgeeknext.model.User;
import com.minty.mintytest.models.RequestPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);
    @Autowired
    private KafkaTemplate<String, RequestPayload> kafkaTemplate;

    String kafkaTopic = "techgeeknext-topic";

    public void send(RequestPayload order) {
        LOG.info("Sending order Json Serializer : {}", order);
        kafkaTemplate.send(kafkaTopic, order);
    }
}