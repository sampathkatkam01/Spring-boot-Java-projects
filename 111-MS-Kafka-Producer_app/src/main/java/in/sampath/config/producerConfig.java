package in.sampath.config;

import java.util.HashMap;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import in.sampath.binding.Order;
import in.sampath.constants.App_constants;

@Configuration
public class producerConfig {

	@Bean
	public ProducerFactory<String, Order> producerfactory() {

		Map<String, Object> configpro = new HashMap<>();
		configpro.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, App_constants.Host);
		configpro.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configpro.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<String, Order>(configpro);
	}

	@Bean
	public KafkaTemplate<String, Order> kafkatemplate() {
		return new KafkaTemplate<>(producerfactory());
	}
}
