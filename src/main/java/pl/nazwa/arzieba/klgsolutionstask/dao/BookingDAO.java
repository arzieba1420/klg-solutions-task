package pl.nazwa.arzieba.klgsolutionstask.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nazwa.arzieba.klgsolutionstask.model.Booking;

import java.util.List;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Long> {

    Booking save(Booking booking);
    Booking findByBookingId(Long id);
    List<Booking> findByRenter_Name(String name);

}
