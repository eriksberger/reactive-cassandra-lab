package se.avega.lab.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.avega.lab.domain.Person;
import se.avega.lab.domain.PersonKey;

@Repository
public interface PersonRepository extends ReactiveCassandraRepository<Person, PersonKey> {
    Flux<Person> findByKeyFirstName(final String firstName);
    Mono<Person> findOneByKeyFirstName(final String firstName);
}
