package com.shop.model;

import com.shop.base.BaseModel;

/**
 * Created by TW on 2017/7/13.
 */
public class Navigation extends BaseModel {

    private Integer orders;
    private boolean isBlankTarget;
    private String name;
    private Integer position;
    private String url;

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public boolean isBlankTarget() {
        return isBlankTarget;
    }

    public void setBlankTarget(boolean blankTarget) {
        isBlankTarget = blankTarget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
