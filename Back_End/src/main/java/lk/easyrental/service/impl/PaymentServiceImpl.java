package lk.easyrental.service.impl;

import lk.easyrental.dto.PaymentDTO;
import lk.easyrental.entity.Payment;
import lk.easyrental.repo.PaymentRepo;
import lk.easyrental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public void savePayment(PaymentDTO dto) {
        if (!paymentRepo.existsById(dto.getPaymentID())){
            paymentRepo.save(mapper.map(dto, Payment.class));
        }else{
            throw new RuntimeException("Already Payed!");
        }
    }

    @Override
    public void deletePayment(String id) {
        if (paymentRepo.existsById(id)){
            paymentRepo.deleteById(id);
        }else{
            throw new RuntimeException("Payment Not Exist..! Please Check ID");
        }
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if (paymentRepo.existsById(dto.getPaymentID())){
            paymentRepo.save(mapper.map(dto,Payment.class));
        }else{
            throw new RuntimeException("Payment Not Exist..! Please Check ID");
        }
    }

    @Override
    public PaymentDTO searchPayment(String id) {
        if (paymentRepo.existsById(id)) {
            return mapper.map(paymentRepo.findById(id).get(), PaymentDTO.class);
        }else{
            throw new RuntimeException("No Payment made For " + id + " ..!");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return mapper.map(paymentRepo.findAll(), new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }
}
