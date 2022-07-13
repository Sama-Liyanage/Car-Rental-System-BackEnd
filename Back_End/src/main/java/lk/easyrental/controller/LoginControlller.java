package lk.easyrental.controller;


import lk.easyrental.dto.LoginDTO;
import lk.easyrental.service.LoginService;
import lk.easyrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/login")
public class LoginControlller {

    @Autowired
    LoginService loginService;

    @ResponseStatus(HttpStatus.CREATED)//201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveLogin(@RequestBody LoginDTO login){
        loginService.saveLogin(login);
        return new ResponseUtil(200,"Saved",null);
    }


}

