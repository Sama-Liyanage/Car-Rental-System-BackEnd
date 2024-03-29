package lk.easyrental.service;

import lk.easyrental.dto.CarDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String id);
    CarDTO searchCar(String id);
    List<CarDTO> getAllCars();
}
