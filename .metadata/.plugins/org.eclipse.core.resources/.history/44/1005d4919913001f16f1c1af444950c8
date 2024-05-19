package in.sampath;

import java.io.IOException; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import in.sampath.service.personalService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);

		personalService bean = context.getBean(personalService.class);
		
		bean.saveAll();
//		bean.delete();
		
	}

}
