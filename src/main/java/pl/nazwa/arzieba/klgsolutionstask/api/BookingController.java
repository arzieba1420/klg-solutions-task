package pl.nazwa.arzieba.klgsolutionstask.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nazwa.arzieba.klgsolutionstask.dto.BookingDTO;
import pl.nazwa.arzieba.klgsolutionstask.model.Booking;
import pl.nazwa.arzieba.klgsolutionstask.model.BookingRequest;
import pl.nazwa.arzieba.klgsolutionstask.service.BookingService;

import java.util.List;

@RestController("booking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/sample")
    public ResponseEntity<Booking> sample(){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/renterBookings/{name}")
    public ResponseEntity<List<BookingDTO>> getBookingsForRenter(@PathVariable String name){
        List<BookingDTO> bookings = bookingService.getBookings(name);
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/addBooking")
    public ResponseEntity<BookingDTO> addNewBooking (@RequestBody BookingRequest bookingRequest){

        BookingDTO bookingDTO = bookingService.addBooking(bookingRequest);
        return ResponseEntity.ok(bookingDTO);
    }

}
