package com.dspringmvc.converter;

import com.dspringmvc.dto.BookingOfficeDTO;
import com.dspringmvc.entity.BookingOfficeEntity;
import com.dspringmvc.service.IBookingOfficeService;
import com.dspringmvc.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingOfficeConvertor {

    public BookingOfficeDTO toDto(BookingOfficeEntity bookingOfficeEntity) {
        BookingOfficeDTO results = new BookingOfficeDTO();
        results.setOfficeId(bookingOfficeEntity.getOfficeId());
        results.setEndContractDate(bookingOfficeEntity.getEndContractDate());
        results.setOfficeName(bookingOfficeEntity.getOfficeName());
        results.setOfficePhone(bookingOfficeEntity.getOfficePhone());
        results.setOfficePlace(bookingOfficeEntity.getOfficePlace());
        results.setOfficePrice(bookingOfficeEntity.getOfficePrice());
        results.setStartContractDate(bookingOfficeEntity.getStartContractDate());
        results.setDestination(bookingOfficeEntity.getTrip().getDestination());
        return results;
    }

    public BookingOfficeEntity toEntity(BookingOfficeDTO bookingOfficeDTO) {
        BookingOfficeEntity results = new BookingOfficeEntity();
        results.setOfficeId(bookingOfficeDTO.getOfficeId());
        results.setEndContractDate(bookingOfficeDTO.getEndContractDate());
        results.setOfficeName(bookingOfficeDTO.getOfficeName());
        results.setOfficePhone(bookingOfficeDTO.getOfficePhone());
        results.setOfficePlace(bookingOfficeDTO.getOfficePlace());
        results.setOfficePrice(bookingOfficeDTO.getOfficePrice());
        results.setStartContractDate(bookingOfficeDTO.getStartContractDate());
        return results;
    }

    public BookingOfficeEntity toEntity(BookingOfficeEntity results, BookingOfficeDTO bookingOfficeDTO) {
        results.setOfficeId(bookingOfficeDTO.getOfficeId());
        results.setEndContractDate(bookingOfficeDTO.getEndContractDate());
        results.setOfficeName(bookingOfficeDTO.getOfficeName());
        results.setOfficePhone(bookingOfficeDTO.getOfficePhone());
        results.setOfficePlace(bookingOfficeDTO.getOfficePlace());
        results.setOfficePrice(bookingOfficeDTO.getOfficePrice());
        results.setStartContractDate(bookingOfficeDTO.getStartContractDate());
        return results;
    }
}
