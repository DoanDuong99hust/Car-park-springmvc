package com.dspringmvc.service;

import com.dspringmvc.dto.BookingOfficeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookingOfficeService {
    BookingOfficeDTO save(BookingOfficeDTO bookingOffice);
    BookingOfficeDTO update(BookingOfficeDTO updateBookingOffice);
    void delete(long[] ids);
    List<BookingOfficeDTO> findAll(Pageable pageble);
    List<BookingOfficeDTO> findAll();
    int getTotalItem();
    BookingOfficeDTO findOne(long id);
}
