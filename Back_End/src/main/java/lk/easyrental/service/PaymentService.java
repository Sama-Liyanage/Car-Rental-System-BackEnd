package lk.easyrental.service;

import lk.easyrental.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDTO dto);
    void deletePayment(String id);
    void updatePayment(PaymentDTO dto);
    PaymentDTO searchPayment(String id);
    List<PaymentDTO> getAllPayments();
}
