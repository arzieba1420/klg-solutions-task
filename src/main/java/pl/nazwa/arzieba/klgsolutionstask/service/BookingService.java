package pl.nazwa.arzieba.klgsolutionstask.service;

import org.springframework.stereotype.Service;
import pl.nazwa.arzieba.klgsolutionstask.dto.BookingDTO;
import pl.nazwa.arzieba.klgsolutionstask.model.BookingRequest;

import java.util.List;

@Service
public interface BookingService {
    List<BookingDTO> getBookings(String renterName);

    BookingDTO addBooking(BookingRequest bookingRequest);
}
