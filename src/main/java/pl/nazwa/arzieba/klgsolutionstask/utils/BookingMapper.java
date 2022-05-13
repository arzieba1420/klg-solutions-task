package pl.nazwa.arzieba.klgsolutionstask.utils;

import org.springframework.stereotype.Component;
import pl.nazwa.arzieba.klgsolutionstask.dao.GuestHouseDAO;
import pl.nazwa.arzieba.klgsolutionstask.dao.PersonDAO;
import pl.nazwa.arzieba.klgsolutionstask.dto.BookingDTO;
import pl.nazwa.arzieba.klgsolutionstask.model.Booking;
import pl.nazwa.arzieba.klgsolutionstask.model.GuestHouse;

import static pl.nazwa.arzieba.klgsolutionstask.utils.CalendarUtil.*;

@Component
public class BookingMapper {

    public static Booking map(BookingDTO bookingDTO, PersonDAO personDAO, GuestHouseDAO guestHouseDAO){

        GuestHouse guestHouse = guestHouseDAO.findByName(bookingDTO.getGuestHouseName());
        return Booking.builder()
                .startDate(string2cal(bookingDTO.getStartDate()))
                .endDate(string2cal(bookingDTO.getEndDate()))
                .landlord(personDAO.findByName(bookingDTO.getLandlordName()))
                .renter(personDAO.findByName(bookingDTO.getRenterName()))
                .guestHouse(guestHouse)
                .totalCost(betweenDays(bookingDTO.getStartDate(),bookingDTO.getEndDate())*guestHouse.getUnitCostPerDay())
                .build();
    }

    public static BookingDTO map (Booking booking){
        return BookingDTO.builder()
                .startDate(cal2string(booking.getStartDate()))
                .endDate(cal2string(booking.getEndDate()))
                .landlordName(booking.getLandlord().getName())
                .renterName(booking.getRenter().getName())
                .guestHouseName(booking.getGuestHouse().getName())
                .totalCost(booking.getTotalCost())
                .build();
    }

}
