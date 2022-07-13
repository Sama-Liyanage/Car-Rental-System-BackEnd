package lk.easyrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MaintainceDTO {
    private String maintainceID;
    private String date;
    private String details;
    private CarDTO car;

}
