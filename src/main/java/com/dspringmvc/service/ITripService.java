package com.dspringmvc.service;


import com.dspringmvc.dto.TripDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ITripService {
    TripDTO save(TripDTO trip);
    TripDTO update(TripDTO updateTrip);
    void delete(long[] ids);
    List<TripDTO> findAll(Pageable pageble);
    List<TripDTO> findAll();
    List<String> findAllDestination();
    int getTotalItem();
    TripDTO findOne(long id);
}
