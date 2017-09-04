package com.shop.model;

import java.util.List;

/**
 * Created by TW on 2017/7/17.
 */
public class ParameterValue {

    private String group;
    private List<Entry> entries;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
