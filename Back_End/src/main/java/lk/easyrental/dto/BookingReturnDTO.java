package lk.easyrental.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookingReturnDTO {

    private String returnID;
    private Date date;
    private double noOfKm;
    private BookingDTO bookingDTO;
    private PaymentDTO paymentDTO;

}
