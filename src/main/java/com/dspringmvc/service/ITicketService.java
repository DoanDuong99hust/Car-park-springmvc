package com.dspringmvc.service;

import com.dspringmvc.dto.TicketDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketService {
    TicketDTO save(TicketDTO ticket);
    TicketDTO update(TicketDTO updateTicket);
    void delete(long[] ids);
    List<TicketDTO> findAll(Pageable pageble);
    List<TicketDTO> findAll();
    int getTotalItem();
    TicketDTO findOne(long id);
}
