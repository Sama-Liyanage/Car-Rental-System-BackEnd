package lk.easyrental.repo;

import lk.easyrental.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login,String> {
}
