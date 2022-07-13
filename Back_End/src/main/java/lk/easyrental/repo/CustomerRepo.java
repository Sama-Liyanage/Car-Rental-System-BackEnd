package lk.easyrental.repo;

import lk.easyrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findTopByOrderByIdDesc();

}