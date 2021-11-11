package com.dspringmvc.controller.carpark.api;

import com.dspringmvc.dto.BookingOfficeDTO;
import com.dspringmvc.service.IBookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingOfficeApi {

    @Autowired
    private IBookingOfficeService iBookingOfficeService;

    @PostMapping("/api/car-park/booking-office")
    public BookingOfficeDTO create(@RequestBody BookingOfficeDTO bookingOfficeDTO) {
        return iBookingOfficeService.save(bookingOfficeDTO);
    }

    @PutMapping("/api/car-park/booking-office")
    public BookingOfficeDTO update(@RequestBody BookingOfficeDTO updateOffice) {
        return iBookingOfficeService.save(updateOffice);
    }

    @DeleteMapping("/api/car-park/booking-office")
    public void delete(@RequestBody long[] ids) {
        iBookingOfficeService.delete(ids);
    }
}
