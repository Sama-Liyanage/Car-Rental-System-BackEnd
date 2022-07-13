package lk.easyrental.service.impl;
import lk.easyrental.dto.MaintenanceDTO;
import lk.easyrental.entity.Maintenance;
import lk.easyrental.repo.MaintenanceRepo;
import lk.easyrental.service.MaintenanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    MaintenanceRepo maintenanceRepo;



    
}
