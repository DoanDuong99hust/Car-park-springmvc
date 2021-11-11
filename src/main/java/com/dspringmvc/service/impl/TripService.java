package com.dspringmvc.service.impl;

import com.dspringmvc.converter.TripConverter;
import com.dspringmvc.dto.TripDTO;
import com.dspringmvc.entity.TripEntity;
import com.dspringmvc.repository.ITripRepository;
import com.dspringmvc.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService implements ITripService {

    @Autowired
    private ITripRepository iTripRepository;

    @Autowired
    private TripConverter tripConverter;

    @Override
    @Transactional
    public TripDTO save(TripDTO trip) {
        TripEntity tripEntity = new TripEntity();
        if (trip.getTripId() != null) {
            TripEntity oldTrip = iTripRepository.findOne(trip.getTripId());
            tripEntity = tripConverter.toEntity(oldTrip, trip);
        } else {
            tripEntity = tripConverter.toEntity(trip);
        }
        return tripConverter.toDto(iTripRepository.save(tripEntity));
    }

    @Override
    public TripDTO update(TripDTO updateTrip) {
        return null;
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids
             ) {
            iTripRepository.delete(id);
        }
    }

    @Override
    public List<TripDTO> findAll(Pageable pageble) {
        List<TripDTO> models = new ArrayList<>();
        List<TripEntity> tripEntityList = iTripRepository.findAll(pageble).getContent();
        for (TripEntity trip:tripEntityList
             ) {
            models.add(tripConverter.toDto(trip));
        }
        return models;
    }

    @Override
    public List<TripDTO> findAll() {
        List<TripDTO> models = new ArrayList<>();
        List<TripEntity> tripEntityList = iTripRepository.findAll();
        for (TripEntity trip:tripEntityList
        ) {
            models.add(tripConverter.toDto(trip));
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) iTripRepository.count();
    }

    @Override
    public TripDTO findOne(long id) {
        TripEntity tripEntity = iTripRepository.findOne(id);
        return tripConverter.toDto(tripEntity);
    }
}
