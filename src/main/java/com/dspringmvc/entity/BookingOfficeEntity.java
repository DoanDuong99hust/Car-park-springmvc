package com.dspringmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookingOffices")
public class BookingOfficeEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;

    @Column(name = "office_name")
    private String officeName;

    @Column(name = "office_phone")
    private String officePhone;

    @Column(name = "office_place")
    private String officePlace;

    @Column(name = "office_price")
    private Long officePrice;

    @Column(name = "start_contract_date")
    private String startContractDate;

    @Column(name = "end_contract_date")
    private String endContractDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tripId")
    private TripEntity trip;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public Long getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(Long officePrice) {
        this.officePrice = officePrice;
    }

    public String getStartContractDate() {
        return startContractDate;
    }

    public void setStartContractDate(String startContractDate) {
        this.startContractDate = startContractDate;
    }

    public String getEndContractDate() {
        return endContractDate;
    }

    public void setEndContractDate(String endContractDate) {
        this.endContractDate = endContractDate;
    }

    public TripEntity getTrip() {
        return trip;
    }

    public void setTrip(TripEntity trip) {
        this.trip = trip;
    }
}
