package com.explore.pojo;

public class Source {
    private Integer id;

    private String sourceName;

    private Integer campusId;

    private String sourcePosition;

    private Float sourceValue;

    private Integer total;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public String getSourcePosition() {
        return sourcePosition;
    }

    public void setSourcePosition(String sourcePosition) {
        this.sourcePosition = sourcePosition == null ? null : sourcePosition.trim();
    }

    public Float getSourceValue() {
        return sourceValue;
    }

    public void setSourceValue(Float sourceValue) {
        this.sourceValue = sourceValue;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}