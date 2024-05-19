package in.sampath.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import in.sampath.binding.Order;
import in.sampath.constants.App_constants;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	public String addMsg(Order order) {

		// publish msg to kafka topic
		kafkaTemplate.send(App_constants.Topic, order);

		return "Msg Published To Kafka Topic";
	}
}
