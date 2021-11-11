package com.dspringmvc.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips")
public class TripEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @Column(name = "booked_ticket_number")
    private Integer bookedTicketNumber;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "departure_date")
    private String departureDate;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "destination")
    private String destination;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "maximun_online_ticket_number")
    private Integer maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "trip")
    List<BookingOfficeEntity>bookingOfficeEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "trip")
    List<TicketEntity> ticketEntityList = new ArrayList<>();

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Integer getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(Integer bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(Integer maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public List<BookingOfficeEntity> getBookingOfficeEntityList() {
        return bookingOfficeEntityList;
    }

    public void setBookingOfficeEntityList(List<BookingOfficeEntity> bookingOfficeEntityList) {
        this.bookingOfficeEntityList = bookingOfficeEntityList;
    }

    public List<TicketEntity> getTicketEntityList() {
        return ticketEntityList;
    }

    public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
        this.ticketEntityList = ticketEntityList;
    }
}
