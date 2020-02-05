import static org.junit.Assert.*;

import Repository.AddressBook;
import Repository.BuddyInfo;
import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class AddressBookTest {
    AddressBook addressBook;
    BuddyInfo buddy;
    BuddyInfo buddy3;

    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();

        buddy = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNum((long) 6131234567.0);
        buddy3 = new BuddyInfo(buddy);
    }

    /*
    @Test
    public void testJPM() {
        addressBook = new AddressBook();

        buddy = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNum((long) 6131234567.0);
        buddy3 = new BuddyInfo(buddy);
        addressBook.insert(buddy);

        // Create the EntityManager
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fdadsf");
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(addressBook);

        tx.commit();

        Query q = em.createQuery("SELECT a FROM AddressBook a");
        List<AddressBook> results = q.getResultList();
        assertEquals(results.get(0).getAddressBook().get(0).getName(), "Homer");

        em.close();
        factory.close();
    }*/

    @Test
    public void testGetSize() {
        addressBook.insert(buddy);
        assertEquals(addressBook.addressBookSize(), 1);
    }

    @Test
    public void testClear() {
        addressBook.clear();
        assertEquals(addressBook.addressBookSize(), 0);
    }

    @Test
    public void testRemove() {
        addressBook.insert(buddy);
        addressBook.remove(buddy);
        assertEquals(addressBook.addressBookSize(), 0);
    }
}
