package com.dspringmvc.repository;

import com.dspringmvc.entity.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParkingLotRepository extends JpaRepository<ParkingLotEntity, Long> {
}
