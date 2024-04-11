package sk.stu.fiit.reservation;

import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sk.stu.fiit.reservation.models.Reservation;
import sk.stu.fiit.reservation.service.ReservationService;

import java.util.logging.Logger;

@SpringBootApplication
@ComponentScan(basePackages = {"sk.stu.fiit.reservation"})
public class Application implements CommandLineRunner {
	private final static Logger LOGGER = Logger.getLogger(Application.class.getName());

	@Autowired
	private ReservationService reservationService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ExternalTaskClient client = ExternalTaskClient.create()
				.baseUrl("http://localhost:8080/engine-rest")
				.asyncResponseTimeout(10000)
				.build();

		client.subscribe("write-reservation")
				.lockDuration(1000)
				.handler((externalTask, externalTaskService) -> {
					String name = externalTask.getVariable("name");
					String surname = externalTask.getVariable("surname");
					String doctor = externalTask.getVariable("doctor");

					Reservation reservation = new Reservation();
					reservation.setName(name);
					reservation.setSurname(surname);
					reservation.setDoctor(doctor);

					reservationService.saveReservation(reservation);

					LOGGER.info("Writing reservation");

					externalTaskService.complete(externalTask);
				})
				.open();
	}
}
