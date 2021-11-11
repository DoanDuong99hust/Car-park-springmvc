package com.dspringmvc.repository;

import com.dspringmvc.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepository extends JpaRepository<TicketEntity, Long> {
}
