package lk.easyrental.service.impl;

import lk.easyrental.dto.CustomerDTO;
import lk.easyrental.entity.Customer;
import lk.easyrental.repo.CarRepo;
import lk.easyrental.repo.CustomerRepo;
import lk.easyrental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (!customerRepo.existsById(dto.getCustomerID())){
            customerRepo.save(mapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer Already Exists! Try Again");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            throw new RuntimeException("Customer Not Exist..! Please Check ID");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerID())){
            customerRepo.save(mapper.map(dto,Customer.class));
        }else{
            throw new RuntimeException("Customer Not Exist..! Please Check ID");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (customerRepo.existsById(id)) {
            return mapper.map(customerRepo.findById(id).get(),CustomerDTO.class);
        }else{
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

}
