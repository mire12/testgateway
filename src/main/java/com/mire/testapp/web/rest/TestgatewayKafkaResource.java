package com.mire.testapp.web.rest;

import com.mire.testapp.service.TestgatewayKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testgateway-kafka")
public class TestgatewayKafkaResource {

    private final Logger log = LoggerFactory.getLogger(TestgatewayKafkaResource.class);

    private TestgatewayKafkaProducer kafkaProducer;

    public TestgatewayKafkaResource(TestgatewayKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
