package com.dspringmvc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parkinglots")
public class ParkingLotEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkId;

    @Column(name = "park_name")
    private String parkName;

    @Column(name = "park_place")
    private String parkPlace;

    @Column(name = "park_area")
    private Long parkArea;

    @Column(name = "park_price")
    private Long parkPrice;

    @Column(name = "park_status")
    private String parkStatus;

    @OneToMany(mappedBy = "park")
    List<CarEntity> carEntityList = new ArrayList<>();


    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public Long getParkArea() {
        return parkArea;
    }

    public void setParkArea(Long parkArea) {
        this.parkArea = parkArea;
    }

    public Long getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(Long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

    public List<CarEntity> getCarEntityList() {
        return carEntityList;
    }

    public void setCarEntityList(List<CarEntity> carEntityList) {
        this.carEntityList = carEntityList;
    }
}
