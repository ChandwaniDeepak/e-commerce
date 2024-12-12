package in.dchandwani.ecommerce.payment.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaPaymentTopicConfig {
    @Bean
    public NewTopic paymentTopic(){
        return TopicBuilder
                .name("payment-topic")
                .build();
    }
}
