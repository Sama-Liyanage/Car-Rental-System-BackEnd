package lk.easyrental.controller;

import lk.easyrental.dto.AdminDTO;
import lk.easyrental.dto.BookingDTO;
import lk.easyrental.entity.Booking;
import lk.easyrental.service.AdminService;
import lk.easyrental.service.BookingService;
import lk.easyrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/booking")
public class BookingController {


    @Autowired
    BookingService bookingService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllBookings() {
        return new ResponseUtil(200,"Ok",bookingService.getAllBooking());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveBooking(@ModelAttribute BookingDTO booking) {
        bookingService.saveBooking(booking);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateBooking(@RequestBody BookingDTO booking) {
        bookingService.updateBooking(booking);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteBooking(@RequestParam String id) {
        bookingService.deleteBooking(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchBooking(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",bookingService.searchBooking(id));
    }


    //Need to add some methods


}
