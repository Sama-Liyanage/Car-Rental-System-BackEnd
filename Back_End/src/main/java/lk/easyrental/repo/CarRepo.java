package lk.easyrental.repo;

import lk.easyrental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String> {

}
