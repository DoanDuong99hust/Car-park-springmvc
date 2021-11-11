package com.dspringmvc.service;

import com.dspringmvc.dto.ParkingLotDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IParkingLotService {
    ParkingLotDTO save(ParkingLotDTO parkingLot);
    ParkingLotDTO update(ParkingLotDTO updateParkingLot);
    void delete(long[] ids);
    List<ParkingLotDTO> findAll(Pageable pageble);
    List<ParkingLotDTO> findAll();
    int getTotalItem();
    ParkingLotDTO findOne(long id);
}
