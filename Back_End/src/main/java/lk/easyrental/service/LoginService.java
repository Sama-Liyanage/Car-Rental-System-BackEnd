package lk.easyrental.service;

import lk.easyrental.dto.LoginDTO;

import java.util.List;

public interface LoginService {
    void saveLogin(LoginDTO dto);
    void updateLogin(LoginDTO dto);
    void deleteLogin(String id);
    LoginDTO searchLogin(String id);
    List<LoginDTO> getAllLogins();
}
