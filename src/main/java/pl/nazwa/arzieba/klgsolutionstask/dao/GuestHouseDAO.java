package pl.nazwa.arzieba.klgsolutionstask.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nazwa.arzieba.klgsolutionstask.model.GuestHouse;

@Repository
public interface GuestHouseDAO extends JpaRepository<GuestHouse, Long> {

    GuestHouse findByName(String name);
}
