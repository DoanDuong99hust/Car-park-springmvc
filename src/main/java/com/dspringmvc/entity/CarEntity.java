package com.dspringmvc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class CarEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "car_color")
    private String carColor;

    @Column(name = "company")
    private String company;

    @Column(name = "license_plate")
    private String licensePlate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parkId")
    private ParkingLotEntity park;

    @OneToMany(mappedBy = "car")
    private List<TicketEntity> ticketEntityList = new ArrayList<>();

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ParkingLotEntity getPark() {
        return park;
    }

    public void setPark(ParkingLotEntity park) {
        this.park = park;
    }

    public List<TicketEntity> getTicketEntityList() {
        return ticketEntityList;
    }

    public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
        this.ticketEntityList = ticketEntityList;
    }
}
