package com.java.librarymanagementsystem;

import java.io.Serializable;

public class User implements Serializable {
    private String name;

    public User(String name) {
        this.setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
