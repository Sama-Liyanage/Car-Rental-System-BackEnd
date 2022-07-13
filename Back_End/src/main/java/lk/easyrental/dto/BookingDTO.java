package lk.easyrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bookingID;
    private String date;
    private String pickupDate;
    private String  returnDate;
    private String status;
    private CustomerDTO customer;
    private CarDTO car;
    private DriverDTO driver;
}
