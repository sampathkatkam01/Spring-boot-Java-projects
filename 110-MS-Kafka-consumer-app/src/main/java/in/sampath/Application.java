package in.sampath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.sampath.constants.App_constants;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@KafkaListener(topics = App_constants.Topic, groupId = "sampathgrouptopic")
	public void getmsg(String Order) {
		System.out.println("*** Msg Recieved From Kafka *** :: ");
		System.out.print(Order);
	}

}
