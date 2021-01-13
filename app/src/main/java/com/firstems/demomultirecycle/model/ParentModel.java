package com.firstems.demomultirecycle.model;

import java.util.List;

public class ParentModel {
    private String title;
    private List<String> listChild;

    public ParentModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getListChild() {
        return listChild;
    }

    public void setListChild(List<String> listChild) {
        this.listChild = listChild;
    }
}
