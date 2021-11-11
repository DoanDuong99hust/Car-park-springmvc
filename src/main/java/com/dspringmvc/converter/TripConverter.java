package com.dspringmvc.converter;

import com.dspringmvc.dto.TripDTO;
import com.dspringmvc.entity.TripEntity;
import org.springframework.stereotype.Component;

@Component
public class TripConverter {

    public TripDTO toDto(TripEntity tripEntity) {
        TripDTO results = new TripDTO();
        results.setTripId(tripEntity.getTripId());
        results.setBookedTicketNumber(tripEntity.getBookedTicketNumber());
        results.setCarType(tripEntity.getCarType());
        results.setDepartureDate(tripEntity.getDepartureDate());
        results.setDepartureTime(tripEntity.getDepartureTime());
        results.setDestination(tripEntity.getDestination());
        results.setDriverName(tripEntity.getDriverName());
        results.setMaximumOnlineTicketNumber(tripEntity.getMaximumOnlineTicketNumber());
        return results;
    }

    public TripEntity toEntity(TripDTO tripDTO) {
        TripEntity results = new TripEntity();
        results.setTripId(tripDTO.getTripId());
        results.setBookedTicketNumber(tripDTO.getBookedTicketNumber());
        results.setCarType(tripDTO.getCarType());
        results.setDepartureDate(tripDTO.getDepartureDate());
        results.setDepartureTime(tripDTO.getDepartureTime());
        results.setDestination(tripDTO.getDestination());
        results.setDriverName(tripDTO.getDriverName());
        results.setMaximumOnlineTicketNumber(tripDTO.getMaximumOnlineTicketNumber());
        return results;
    }

    public TripEntity toEntity(TripEntity results, TripDTO tripDTO) {
        results.setTripId(tripDTO.getTripId());
        results.setBookedTicketNumber(tripDTO.getBookedTicketNumber());
        results.setCarType(tripDTO.getCarType());
        results.setDepartureDate(tripDTO.getDepartureDate());
        results.setDepartureTime(tripDTO.getDepartureTime());
        results.setDestination(tripDTO.getDestination());
        results.setDriverName(tripDTO.getDriverName());
        results.setMaximumOnlineTicketNumber(tripDTO.getMaximumOnlineTicketNumber());
        return results;
    }
}
