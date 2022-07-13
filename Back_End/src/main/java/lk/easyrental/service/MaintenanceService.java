package lk.easyrental.service;

import lk.easyrental.dto.MaintenanceDTO;

import java.util.List;

public interface MaintenanceService {
    void saveMaintenance(MaintenanceDTO dto);
    void deleteMaintenance(String id);
    void updateMaintenance(MaintenanceDTO dto);
    MaintenanceDTO searchMaintenance(String id);
    List<MaintenanceDTO> getMaintenance();
}
