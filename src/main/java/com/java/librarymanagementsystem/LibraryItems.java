package com.java.librarymanagementsystem;

import java.io.Serializable;

public abstract class LibraryItems implements Serializable {
    private String title;
    private String author;
    private String serialNumber;
    protected boolean isBorrowed;

    public LibraryItems(String title, String author, String serialNumber) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setSerialNumber(serialNumber);
        this.isBorrowed = false;
    }

    public abstract void borrowItem(User user);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


}
