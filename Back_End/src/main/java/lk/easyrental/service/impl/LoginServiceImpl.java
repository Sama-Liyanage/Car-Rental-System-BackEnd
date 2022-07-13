package lk.easyrental.service.impl;

import lk.easyrental.dto.LoginDTO;
import lk.easyrental.entity.Login;
import lk.easyrental.repo.LoginRepo;
import lk.easyrental.service.LoginService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    LoginRepo loginRepo;

    @Override
    public void saveLogin(LoginDTO dto) {
        if (!loginRepo.existsById(dto.getLoginID())){
            loginRepo.save(mapper.map(dto, Login.class));
        }else{
            throw new RuntimeException("User Already logged! Try Again");
        }
    }

    @Override
    public void deleteLogin(String id) {
        if (loginRepo.existsById(id)){
            loginRepo.deleteById(id);
        }else{
            throw new RuntimeException("User Not Exist..! Please Check ID");
        }
    }

    @Override
    public void updateLogin(LoginDTO dto) {
        if (loginRepo.existsById(dto.getLoginID())){
            loginRepo.save(mapper.map(dto,Login.class));
        }else{
            throw new RuntimeException("User Not Exist..! Please Check ID");
        }
    }

    @Override
    public LoginDTO searchLogin(String id) {
        if (loginRepo.existsById(id)) {
            return mapper.map(loginRepo.findById(id).get(), LoginDTO.class);
        }else{
            throw new RuntimeException("No User For " + id + " ..!");
        }
    }

    @Override
    public List<LoginDTO> getAllLogins() {
        return mapper.map(loginRepo.findAll(),new TypeToken<List<LoginDTO>>(){}.getType());
    }

}
