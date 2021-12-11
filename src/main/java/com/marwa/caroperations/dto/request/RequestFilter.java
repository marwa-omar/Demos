package com.marwa.caroperations.requestDtos;

public class RequestFilter {
    private String search;
    private String orderByName;
    private String orderByModel;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrderByName() {
        return orderByName;
    }

    public void setOrderByName(String orderByName) {
        this.orderByName = orderByName;
    }

    public String getOrderByModel() {
        return orderByModel;
    }

    public void setOrderByModel(String orderByModel) {
        this.orderByModel = orderByModel;
    }
}
