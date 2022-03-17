package com.example.assignmenttops.readContacts;

public class Contact {
    String phoneNumber,Name;

    public Contact() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Contact(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        Name = name;
    }

    @Override
    public String toString() {
        return
                "Phone Number=" + phoneNumber + '\n' +
                "Name=" + Name;
    }
}
