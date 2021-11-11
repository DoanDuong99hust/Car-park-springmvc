package com.dspringmvc.repository;

import com.dspringmvc.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<CarEntity, Long> {
}
