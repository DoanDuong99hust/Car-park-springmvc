package com.dspringmvc.service;

import com.dspringmvc.dto.CarDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICarService {
    CarDTO save(CarDTO car);
    CarDTO update(CarDTO updateCar);
    void delete(long[] carIds);
    List<CarDTO> findAll(Pageable pageble);
    List<CarDTO> findAll();
    int getTotalItem();
    CarDTO findOne(long carId);
}
