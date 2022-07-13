package lk.easyrental.repo;

import lk.easyrental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,String> {


}
