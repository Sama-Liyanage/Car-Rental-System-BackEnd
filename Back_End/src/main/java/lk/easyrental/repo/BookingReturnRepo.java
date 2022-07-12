package lk.easyrental.repo;

import lk.easyrental.entity.BookingReturn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingReturnRepo extends JpaRepository<BookingReturn,String> {

}
