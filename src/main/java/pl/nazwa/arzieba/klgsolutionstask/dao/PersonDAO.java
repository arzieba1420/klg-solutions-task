package pl.nazwa.arzieba.klgsolutionstask.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nazwa.arzieba.klgsolutionstask.model.Booking;
import pl.nazwa.arzieba.klgsolutionstask.model.Person;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {

    Person findByPersonId(long id);
    Person findByName(String name);
}
