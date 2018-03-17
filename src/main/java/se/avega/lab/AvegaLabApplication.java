package se.avega.lab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.avega.lab.domain.Person;
import se.avega.lab.domain.PersonKey;
import se.avega.lab.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AvegaLabApplication implements CommandLineRunner {

    private static final Logger log = LogManager.getLogger(AvegaLabApplication.class);

    @Autowired
    private PersonRepository personRepository;

    public static void main(final String[] args) {
        SpringApplication.run(AvegaLabApplication.class);
    }

    @Override
    public void run(String... args) {
        personRepository.insert(createABunchOfData()).subscribe();
        personRepository.insert(createASingleDataPint()).subscribe();
        personRepository.findAll().map(Person::getLastName).subscribe(this::doSomethingClever);
        personRepository.findByKeyFirstName("John").map(Person::getLastName).subscribe(this::doSomethingClever);

    }

    private Person createASingleDataPint() {
        return new Person(new PersonKey("Jens", LocalDateTime.now(), UUID.randomUUID()), "Eriksberger", 50);
    }

    private List<Person> createABunchOfData() {
        final Person a = new Person(new PersonKey("John", LocalDateTime.now(), UUID.randomUUID()), "Doe", 1000);
        final Person b = new Person(new PersonKey("John", LocalDateTime.now(), UUID.randomUUID()), "Mackinroe", 1000);
        final Person c = new Person(new PersonKey("John", LocalDateTime.now(), UUID.randomUUID()), "Legend", 1000);
        final Person d = new Person(new PersonKey("Not John", LocalDateTime.now(), UUID.randomUUID()), "Duh", 1000);
        return Arrays.asList(a, b, c, d);
    }

    private void doSomethingClever(String content) {
        log.info(content);
    }
}
