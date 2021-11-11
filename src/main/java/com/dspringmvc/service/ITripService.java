package com.dspringmvc.service;


import com.dspringmvc.dto.TripDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITripService {
    TripDTO save(TripDTO trip);
    TripDTO update(TripDTO updateTrip);
    void delete(long[] ids);
    List<TripDTO> findAll(Pageable pageble);
    List<TripDTO> findAll();
    int getTotalItem();
    TripDTO findOne(long id);
}
