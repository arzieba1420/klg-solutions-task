package pl.nazwa.arzieba.klgsolutionstask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue
    private Long bookingId;
    @Temporal(TemporalType.DATE)
    private Calendar startDate;
    @Temporal(TemporalType.DATE)
    private Calendar endDate;
    @ManyToOne
    @JoinColumn (name = "landlordName", referencedColumnName = "name")
    private Person landlord;
    @ManyToOne
    @JoinColumn (name = "renterName", referencedColumnName = "name")
    private Person renter;
    @ManyToOne
    @JoinColumn(name = "guestHouesId", referencedColumnName = "guestHouseId",nullable = false)
    private GuestHouse guestHouse;
    private double totalCost;
}
