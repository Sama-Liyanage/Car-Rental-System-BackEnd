package lk.easyrental.service.impl;


import lk.easyrental.dto.AdminDTO;
import lk.easyrental.entity.Admin;
import lk.easyrental.repo.AdminRepo;
import lk.easyrental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminID())) {
            repo.save(mapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("Admin Already Exists");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the AdminID.. No Such Admin..!");
        }
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminID())) {
            repo.save(mapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("No Such Admin To Update..! Please Check the ID..!");
        }

    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), AdminDTO.class);
        }else{
            throw new RuntimeException("No Admin found For " + id + " ..!");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        return mapper.map(repo.findAll(), new TypeToken<List<AdminDTO>>() {
        }.getType());
    }
}







