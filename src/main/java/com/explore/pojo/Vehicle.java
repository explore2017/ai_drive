package com.explore.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Vehicle {
    private Integer id;

    private String name;

    private Integer price;

    private Integer compusId;

    private Integer coachId;

    private Integer status;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date purchaseTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCompusId() {
        return compusId;
    }

    public void setCompusId(Integer compusId) {
        this.compusId = compusId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}