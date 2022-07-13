package lk.easyrental.repo;

import lk.easyrental.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepo extends JpaRepository<Maintenance,String> {

}
