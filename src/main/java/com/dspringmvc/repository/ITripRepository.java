package com.dspringmvc.repository;

import com.dspringmvc.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITripRepository extends JpaRepository<TripEntity, Long> {
}
