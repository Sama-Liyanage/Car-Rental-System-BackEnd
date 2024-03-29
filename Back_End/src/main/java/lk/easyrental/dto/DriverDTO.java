package lk.easyrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverID;
    private String name;
    private int contactNo;
    private String nic;
    private String userName;
    private String password;
    private boolean available;


}
