package lk.easyrental.controller;

import lk.easyrental.dto.PaymentDTO;
import lk.easyrental.service.PaymentService;
import lk.easyrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPayments(){
        return new ResponseUtil(200,"Ok",paymentService.getAllPayments());
    }

    @ResponseStatus(HttpStatus.CREATED)//201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePayment(@RequestBody PaymentDTO payment){
        paymentService.savePayment(payment);
        return new ResponseUtil(200,"Saved",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updatePayment(@RequestBody PaymentDTO payment){
        paymentService.updatePayment(payment);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletePayments(@PathVariable String id){
        paymentService.deletePayment(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchPayments(@PathVariable String id){
        return new ResponseUtil(200,"Ok",paymentService.searchPayment(id));
    }



}
