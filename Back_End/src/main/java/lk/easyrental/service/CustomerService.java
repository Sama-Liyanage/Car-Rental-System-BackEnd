package lk.easyrental.service;

import lk.easyrental.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    CustomerDTO searchCustomer(String id);
    List<CustomerDTO> getAllCustomers();
}
