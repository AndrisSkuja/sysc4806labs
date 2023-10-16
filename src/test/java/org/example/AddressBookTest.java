package org.example;

import jakarta.persistence.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.springframework.data.repository.CrudRepository;

public class AddressBookTest {

    AddressBook testBook = new AddressBook();

    @Test
    public void addbuddytest() {
        BuddyInfo testbuddy = new BuddyInfo("tom","address","42");
        testBook.addBuddy(testbuddy);
        assertEquals(testBook.getMylist().get(0),testbuddy);
    }

    @Test
    public void removebuddytest() {
        BuddyInfo testbuddy = new BuddyInfo("tom","address","42");
        testBook.addBuddy(testbuddy);
        assertEquals(testBook.removeBuddy(testbuddy),testbuddy);
    }

    @Test
    public void persisttest(){

        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setName("Joe");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setName("Joe2");

        AddressBook mybook = new AddressBook();



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        //em.persist(buddy1);
        //em.persist(buddy2);

        mybook.addBuddy(buddy1);
        mybook.addBuddy(buddy2);

        em.persist(mybook);

        tx.commit();

        Query q = em.createQuery("SELECT p from AddressBook p");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of BuddyInfos\n----------------");

        for (AddressBook p : results) {

            System.out.println(p.getMylist().get(0).getName() + "\n"+p.getMylist().get(0).getAddress()+"\n"+p.getMylist().get(0).getNumber());
        }

        em.close();

        emf.close();
    }
}