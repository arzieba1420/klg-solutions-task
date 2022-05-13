package pl.nazwa.arzieba.klgsolutionstask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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
    private long bookingId;
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
    @JoinColumn(name = "guestHouesId", referencedColumnName = "guestHouseId")
    @Column(nullable = false)
    private GuestHouse guestHouse;
    private double totalCost;
    @PreUpdate
    @PrePersist
    private void calcTotalCost (){
        long days = ChronoUnit.DAYS.between(startDate.toInstant(),endDate.toInstant());
        totalCost = days*guestHouse.getUnitCostPerDay();
    }
}
