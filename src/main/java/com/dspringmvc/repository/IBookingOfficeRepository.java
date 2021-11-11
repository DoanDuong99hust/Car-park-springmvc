package com.dspringmvc.repository;

import com.dspringmvc.entity.BookingOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingOfficeRepository extends JpaRepository<BookingOfficeEntity, Long> {
}
