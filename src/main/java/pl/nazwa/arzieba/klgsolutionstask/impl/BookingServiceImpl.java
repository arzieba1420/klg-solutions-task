package pl.nazwa.arzieba.klgsolutionstask.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nazwa.arzieba.klgsolutionstask.dao.BookingDAO;
import pl.nazwa.arzieba.klgsolutionstask.dao.GuestHouseDAO;
import pl.nazwa.arzieba.klgsolutionstask.dao.PersonDAO;
import pl.nazwa.arzieba.klgsolutionstask.dto.BookingDTO;
import pl.nazwa.arzieba.klgsolutionstask.model.Booking;
import pl.nazwa.arzieba.klgsolutionstask.model.BookingRequest;
import pl.nazwa.arzieba.klgsolutionstask.model.GuestHouse;
import pl.nazwa.arzieba.klgsolutionstask.service.BookingService;
import pl.nazwa.arzieba.klgsolutionstask.utils.BookingMapper;
import pl.nazwa.arzieba.klgsolutionstask.utils.CalendarUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingDAO bookingDAO;
    private PersonDAO personDAO;
    private GuestHouseDAO guestHouseDAO;

    @Autowired
    public BookingServiceImpl(BookingDAO bookingDAO, PersonDAO personDAO, GuestHouseDAO guestHouseDAO) {
        this.bookingDAO = bookingDAO;
        this.personDAO = personDAO;
        this.guestHouseDAO = guestHouseDAO;
    }

    @Override
    public List<BookingDTO> getBookings(String renterName) {

        System.out.println();
        List<BookingDTO> collect = bookingDAO.findByRenter_Name(renterName).stream().map(BookingMapper::map).collect(Collectors.toList());
        System.out.println();
        return collect;
    }

    @Override
    public BookingDTO addBooking(BookingRequest bookingRequest) {
        GuestHouse guestHouse = guestHouseDAO.findByName(bookingRequest.getGuestHouseName());

        BookingDTO bookingDTO = BookingDTO.builder()
                .guestHouseName(bookingRequest.getGuestHouseName())
                .landlordName(bookingRequest.getLandlordName())
                .renterName(bookingRequest.getRenterName())
                .endDate(bookingRequest.getEndDate())
                .startDate(bookingRequest.getStartDate())
                .totalCost(CalendarUtil.betweenDays(bookingRequest.getStartDate(),bookingRequest.getEndDate())*guestHouse.getUnitCostPerDay())
                .build();

        Booking save = bookingDAO.save(BookingMapper.map(bookingDTO, personDAO, guestHouseDAO));
        System.out.println();

        return bookingDTO;
    }
}
