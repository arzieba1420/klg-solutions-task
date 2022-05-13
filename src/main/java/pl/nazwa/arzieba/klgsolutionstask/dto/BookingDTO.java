package pl.nazwa.arzieba.klgsolutionstask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private String startDate;
    private String endDate;
    private String landlordName;
    private String renterName;
    private String guestHouseName;
    private double totalCost;


}
