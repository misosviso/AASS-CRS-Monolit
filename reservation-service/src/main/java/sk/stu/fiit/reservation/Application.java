package sk.stu.fiit.reservation;

import org.springframework.boot.SpringApplication;
import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;
import java.util.logging.Logger;


@SpringBootApplication
public class Application {
	private final static Logger LOGGER = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		ExternalTaskClient client = ExternalTaskClient.create()
				.baseUrl("http://localhost:8080/engine-rest")
				.asyncResponseTimeout(10000) // long polling timeout
				.build();

		// subscribe to an external task topic as specified in the process
		client.subscribe("write-reservation")
				.lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
				.handler((externalTask, externalTaskService) -> {
					// Put your business logic here

//					// Get a process variable
//					String item = externalTask.getVariable("item");
//					Integer amount = externalTask.getVariable("amount");

					LOGGER.info("Writing reservation");

//					try {
//						Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//
//					// Complete the task
					externalTaskService.complete(externalTask);
				})
				.open();
	}

}
