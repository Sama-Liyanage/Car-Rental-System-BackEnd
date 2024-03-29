package lk.easyrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookingReturn {
    @Id
    private String returnID;
    private Date date;
    private double noOfKm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookingID", referencedColumnName = "bookingID",nullable = false)
    private Booking booking;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentID", referencedColumnName = "paymentID",nullable = false)

    private Payment payment;
}
