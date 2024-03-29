package lk.easyrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String carID;
//    private String registrationNumber;
    private String brand;
    private String type;
    private int numberOfPassengers;
    private String transmissionType;
    private String fuelType;
    private String colour;
    private double dailyRate;
    private double monthlyRate;
//    private double freeMillagePrice;
//    private String freeMillageDuration;
private double freeKmforMonth;
    private double freeKmforDay;
    private double lossDamageWaiver;
    private double priceForExtraKM;
    private String status;
    private double completeKm;

}
