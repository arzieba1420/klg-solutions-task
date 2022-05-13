package pl.nazwa.arzieba.klgsolutionstask.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long guestHouseId;
    @NotBlank(message = "Set proper name for Guest Hotel!")
    private String name;
    @Positive(message = "Unit cost may not be negative!")
    private double unitCostPerDay;
    @Positive(message = "Guest House area may not be negative!")
    private double totalArea;
    @NotBlank(message = "Set proper name for Guest Hotel!")
    @Lob
    private String description;
    @OneToMany(mappedBy = "guestHouse")
    List<Booking> bookings;
}
