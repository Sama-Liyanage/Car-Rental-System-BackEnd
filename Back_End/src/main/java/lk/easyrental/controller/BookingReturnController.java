package lk.easyrental.controller;


import lk.easyrental.dto.BookingDTO;
import lk.easyrental.dto.BookingReturnDTO;
import lk.easyrental.service.BookingReturnService;
import lk.easyrental.service.BookingService;
import lk.easyrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/bookingReturn")
public class BookingReturnController {

    @Autowired
    BookingReturnService bookingReturnService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllBookingReturn(){
        return new ResponseUtil(200,"Ok",bookingReturnService.getAllBookingReturns());
    }

    @ResponseStatus(HttpStatus.CREATED)//201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveBookingReturn(@RequestBody BookingReturnDTO bookingReturn){
        bookingReturnService.saveBookingReturn(bookingReturn);
        return new ResponseUtil(200,"Saved",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateBookingReturn(@RequestBody BookingReturnDTO bookingReturn){
        bookingReturnService.updateBookingReturn(bookingReturn);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteBookingReturn(@PathVariable String id){
        bookingReturnService.deleteBookingReturn(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchBookingReturn(@PathVariable String id){
        return new ResponseUtil(200,"Ok",bookingReturnService.searchBookingReturn(id));
    }

}
