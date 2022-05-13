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
    private Long guestHouseId;
    @Column(unique = true)
    private String name;
    private double unitCostPerDay;
    private double totalArea;
    @Lob
    private String description;
    @OneToMany(mappedBy = "guestHouse")
    List<Booking> bookings;
}
