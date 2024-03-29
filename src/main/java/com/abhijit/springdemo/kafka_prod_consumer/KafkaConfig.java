package com.abhijit.springdemo.kafka_prod_consumer;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

  @Bean
  public ProducerFactory<String, SimpleModel> producerFactory(){
     Map<String,Object> config = new HashMap<>();
     config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
     config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
     config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
     return  new DefaultKafkaProducerFactory<>(config);
  }

  @Bean
  public KafkaTemplate<String,SimpleModel> kafkaTemplate(){
    return  new KafkaTemplate<>(producerFactory());

  }
}
