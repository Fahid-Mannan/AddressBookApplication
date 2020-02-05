import Repository.BuddyInfo;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    BuddyInfo buddy;
    BuddyInfo buddy2;
    BuddyInfo buddy3;

    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo();
        buddy2 = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNum((long) 6131234567.0);
        buddy3 = new BuddyInfo(buddy);
    }

    @Test
    public void testJPA() {
        BuddyInfo buddy5;
        BuddyInfo buddy6;
        BuddyInfo buddy7;

        buddy5 = new BuddyInfo();
        //buddy6 = new Repository.BuddyInfo();
        buddy5.setName("Homer");
        buddy5.setAddress("1125 Colonel By");
        buddy5.setPhoneNum((long) 6131234567.0);
        buddy7 = new BuddyInfo(buddy5);

        // Create the EntityManager
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fdadsf");
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //em.getTransaction().begin();

        em.persist(buddy5);
        //em.persist(buddy6);
        em.persist(buddy7);

        tx.commit();

        Query q = em.createQuery("SELECT b FROM BuddyInfo b");
        List<BuddyInfo> results = q.getResultList();
        assertEquals(results.size(), 2);

        em.close();
        factory.close();
    }

    @Test
    public void testGetName() {
        assertEquals(buddy.getName(), "Homer");
        assertEquals(buddy3.getName(), "Homer");
    }

    @Test
    public void testSetName() {
        buddy2.setName("Albert");
        assertEquals(buddy2.getName(), "Albert");
    }

    @Test
    public void testGetAddress() {
        assertEquals(buddy.getAddress(), "1125 Colonel By");
        assertEquals(buddy3.getAddress(), "1125 Colonel By");
    }

    @Test
    public void testSetAddress() {
        buddy2.setAddress("Wellington St");
        assertEquals(buddy2.getAddress(), "Wellington St");
    }

    @Test
    public void testGetPhoneNum() {
        assertEquals(buddy.getPhoneNum(),  6131234567.0, 1.0);
        assertEquals(buddy3.getPhoneNum(),  6131234567.0, 1.0);
    }

    @Test
    public void testSetPhoneNum() {
        buddy2.setPhoneNum(123456);
        assertEquals(buddy2.getPhoneNum(),  123456, 1.0);
    }
}
