package org.example;

import jakarta.persistence.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    BuddyInfo testbuddy;

    @Test
    public void createtest() {
        testbuddy = new BuddyInfo("testname","testAddress","2");
        assertEquals(testbuddy.getName(),"testname");
        assertEquals(testbuddy.getAddress(),"testAddress");
        assertEquals(testbuddy.getNumber(),"2");
    }

    @Test
    public void persisttest(){

        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setName("Joe");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setName("Joe2");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();

        Query q = em.createQuery("SELECT p from BuddyInfo p");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of BuddyInfos\n----------------");

        for (BuddyInfo p : results) {

            System.out.println(p.getName() + "\n"+p.getAddress()+"\n"+p.getNumber());
        }

        em.close();

        emf.close();
    }
}