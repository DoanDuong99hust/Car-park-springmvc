package com.dspringmvc.service.impl;

import com.dspringmvc.converter.BookingOfficeConvertor;
import com.dspringmvc.dto.BookingOfficeDTO;
import com.dspringmvc.entity.BookingOfficeEntity;
import com.dspringmvc.repository.IBookingOfficeRepository;
import com.dspringmvc.service.IBookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingOfficeService implements IBookingOfficeService {

    @Autowired
    private IBookingOfficeRepository iBookingOfficeRepository;

    @Autowired
    private BookingOfficeConvertor bookingOfficeConvertor;

    @Override
    @Transactional
    public BookingOfficeDTO save(BookingOfficeDTO bookingOffice) {
        BookingOfficeEntity bookingOfficeEntity = new BookingOfficeEntity();
        if (bookingOffice.getOfficeId() != null) {
            BookingOfficeEntity oldOffice = iBookingOfficeRepository.findOne(bookingOffice.getOfficeId());
            bookingOfficeEntity = bookingOfficeConvertor.toEntity(oldOffice, bookingOffice);
        } else {
            bookingOfficeEntity = bookingOfficeConvertor.toEntity(bookingOffice);
        }
        return bookingOfficeConvertor.toDto(iBookingOfficeRepository.save(bookingOfficeEntity));
    }

    @Override
    public BookingOfficeDTO update(BookingOfficeDTO updateBookingOffice) {
        return null;
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            iBookingOfficeRepository.delete(id);
        }
    }

    @Override
    public List<BookingOfficeDTO> findAll(Pageable pageble) {
        List<BookingOfficeDTO> models = new ArrayList<>();
        List<BookingOfficeEntity> bookingOfficeEntityList = iBookingOfficeRepository.findAll(pageble).getContent();
        for (BookingOfficeEntity office: bookingOfficeEntityList
             ) {
            models.add(bookingOfficeConvertor.toDto(office));
        }
        return models;
    }

    @Override
    public List<BookingOfficeDTO> findAll() {
        List<BookingOfficeDTO> models = new ArrayList<>();
        List<BookingOfficeEntity> bookingOfficeEntityList = iBookingOfficeRepository.findAll();
        for (BookingOfficeEntity office: bookingOfficeEntityList
        ) {
            models.add(bookingOfficeConvertor.toDto(office));
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) iBookingOfficeRepository.count();
    }

    @Override
    public BookingOfficeDTO findOne(long id) {
        BookingOfficeEntity bookingOfficeEntity = iBookingOfficeRepository.findOne(id);
        return bookingOfficeConvertor.toDto(bookingOfficeEntity);
    }
}
