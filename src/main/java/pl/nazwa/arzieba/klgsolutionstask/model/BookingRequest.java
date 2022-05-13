package pl.nazwa.arzieba.klgsolutionstask.model;

import io.swagger.annotations.ApiModelProperty;
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
public class BookingRequest {
    @ApiModelProperty(
            example = "yyyy-mm-dd")
    private String startDate ;
    @ApiModelProperty(
            example = "yyyy-mm-dd")
    private String endDate ;
    private String landlordName;
    private String renterName;
    private String guestHouseName;
}
