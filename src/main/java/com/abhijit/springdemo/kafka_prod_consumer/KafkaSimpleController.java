package com.abhijit.springdemo.kafka_prod_consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaSimpleController {

  private KafkaTemplate<String, SimpleModel> kafkaTemplate;

  @Autowired
  public KafkaSimpleController(KafkaTemplate<String,SimpleModel> kafkaTemplate){
     this.kafkaTemplate = kafkaTemplate;
  }

  @PostMapping
  public void post(@RequestBody SimpleModel simpleModel){
       kafkaTemplate.send("myTopic",simpleModel);
  }

}
