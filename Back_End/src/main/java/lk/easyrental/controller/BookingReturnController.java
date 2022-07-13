package lk.easyrental.controller;


import lk.easyrental.service.BookingReturnService;
import lk.easyrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/bookingReturn")
public class BookingReturnController {

    @Autowired
    BookingReturnService bookingReturnService;

}
