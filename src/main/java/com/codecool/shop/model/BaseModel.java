package com.codecool.shop.model;


import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.lang.reflect.Field;
import java.util.Locale;

public class BaseModel {

    protected int id;
    protected String name;
    protected String description;
    protected String url;

    public BaseModel(String name) {
        this.name = name;
        this.url = name.toLowerCase(Locale.ROOT).replace(" ", "-");
    }

    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
        this.url = name.toLowerCase(Locale.ROOT).replace(" ", "-");
    }

    public BaseModel(int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

    public String getUrl() {
        return url;
    }
}
