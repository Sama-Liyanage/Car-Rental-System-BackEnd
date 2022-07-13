package lk.easyrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MaintenanceDTO {
    private String maintenanceID;
    private String date;
    private String details;
    private CarDTO car;

}
