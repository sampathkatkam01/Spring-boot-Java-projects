package in.sampath.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;



import in.sampath.binding.Order;
import in.sampath.constants.App_constants;

@Configuration
public class ConsumerConfiguration {

	@Bean
	public ConsumerFactory<String, Order> consumerFactory() {

		Map<String, Object> configprops = new HashMap<>();
		configprops.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, App_constants.Host);
		configprops.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configprops.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configprops);

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Order> listernerfactory() {
		ConcurrentKafkaListenerContainerFactory<String, Order> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
