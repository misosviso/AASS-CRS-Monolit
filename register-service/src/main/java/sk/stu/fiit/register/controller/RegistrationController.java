package sk.stu.fiit.register.controller;

import sk.stu.fiit.register.model.RegistrationCredentials;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping
    public List<RegistrationCredentials> getStudent() {
        System.out.println("getting reservations");
        return Arrays.asList(new RegistrationCredentials());
    }

    @PostMapping
    public Boolean createStudent(@RequestBody RegistrationCredentials registrationCredentials) {
        System.out.println("creating reservation:"+ registrationCredentials);
        return true;
    }

}
