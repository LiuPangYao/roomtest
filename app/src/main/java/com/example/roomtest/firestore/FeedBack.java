package com.example.roomtest.firestore;

public class FeedBack {

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public FeedBack(String contact, String title, String details) {
        Contact = contact;
        Title = title;
        Details = details;
    }

    public FeedBack() {}

    private String Contact;
    private String Title;
    private String Details;
}
