package lk.easyrental.controller;

import lk.easyrental.dto.AdminDTO;
import lk.easyrental.service.AdminService;
import lk.easyrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAdmins() {
        return new ResponseUtil(200,"Ok",adminService.getAllAdmin());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO admin) {
        adminService.saveAdmin(admin);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO admin) {
        adminService.updateAdmin(admin);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String id) {
        adminService.deleteAdmin(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",adminService.searchAdmin(id));
    }

}

