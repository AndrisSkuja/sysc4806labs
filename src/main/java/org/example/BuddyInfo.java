package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {

    private String address;
    private String number;


    private String name;

    @Id @GeneratedValue
    private int ID;


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuddyInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

//    public BuddyInfo(String address, String number, String name) {
//        this.address = address;
//        this.number = Integer.valueOf((String) number);;
//        this.name = name;
//    }

    public BuddyInfo() {
        this.name = "name";
        this.address = "address";
        this.number = "0";
    }




    public static void main(String[] args) {
        BuddyInfo test = new BuddyInfo("Homer","idk","6");
        String name = test.getName();
        System.out.println("Hello " + name);
    }
}
