package lk.easyrental.repo;

import lk.easyrental.entity.Maintaince;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarMaintenanceRepo extends JpaRepository<Maintaince,String> {
}
