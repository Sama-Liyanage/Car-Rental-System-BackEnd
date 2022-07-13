package lk.easyrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Maintenance {
    @Id
    private String maintenanceID;
    private String date;
    private String details;

    @ManyToOne
    @JoinColumn(name = "carID", referencedColumnName = "carID",nullable = false)
    private Car car;
}
