package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany (cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<BuddyInfo> mylist;


    public AddressBook(List<BuddyInfo> mylist) {
        this.mylist = mylist;
    }

    public AddressBook() {
        this(new ArrayList<BuddyInfo>());
    }

    public void addBuddy(BuddyInfo newBuddy) {
        mylist.add(newBuddy);
    }

    public BuddyInfo removeBuddy(BuddyInfo oldBuddy) {
        for(int i = 0; i < mylist.size(); i++){
            if (mylist.get(i) == oldBuddy){
                return mylist.remove(i);
            }
        }
        return null;
    }

    public void printer(){
        for(BuddyInfo i : this.mylist){
            System.out.println("name: "+i.getName()+", address: "+ i.getAddress()+", number: "+i.getNumber());
        }
    }


    public List<BuddyInfo> getMylist() {
        return mylist;
    }

    public void setMylist(List<BuddyInfo> mylist) {
        this.mylist = mylist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        System.out.println("Address Book");
        AddressBook mybook = new AddressBook();
        BuddyInfo myBuddy = new BuddyInfo("Tom", "dunno", "6");
        BuddyInfo myBuddy2 = new BuddyInfo("Tom2", "dunno2", "62");
        mybook.addBuddy(myBuddy);
        mybook.addBuddy(myBuddy2);

        mybook.printer();
        //mybook.removeBuddy(myBuddy);
    }
}
