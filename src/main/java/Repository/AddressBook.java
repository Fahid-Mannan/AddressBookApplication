package Repository;

import javax.persistence.*;
import java.util.*;

@Entity
public class AddressBook {
    private long id;
    private List<BuddyInfo> addressBook;

    public AddressBook() {
        addressBook = new ArrayList<BuddyInfo>();
    }

    public void insert(BuddyInfo buddy) {
        addressBook.add(buddy);
    }

  //  public void remove(BuddyInfo buddy) {
       // addressBook.remove(buddy);
   // }

    public void remove(BuddyInfo buddy) {
        Boolean found = false;
        for (BuddyInfo buddyLoop: addressBook) {
           if (buddyLoop.equals(buddy)) {
               found = true;
               break;
           }
        }

        if (found) {
            addressBook.remove(buddy);
        }
    }

    public void remove(String name) {
        Boolean found = false;
        int index = -1;
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getName().equals(name)) {
                found = true;
                index = i;
            }
        }

        if (found && index != -1) {
            addressBook.remove(index);
        }
    }


    @OneToMany(cascade = CascadeType.ALL)
    public List<BuddyInfo> getBuddies() {
        return addressBook;
    }

    public void setBuddies(List<BuddyInfo> addressBook) {
        this.addressBook = addressBook;
    }

    public int addressBookSize() { return this.addressBook.size(); }

    @Id
    @GeneratedValue
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public void clear() {
        addressBook.clear();
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < addressBook.size(); i++) {
            s += addressBook.get(i) + "\n";
        }

        return s;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Address Book");
        AddressBook book = new AddressBook();
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName("Fahid");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setName("Fahid2.0");

        BuddyInfo buddy3 = new BuddyInfo();
        buddy3.setName("Fahid3.0");

        book.insert(buddy);
        book.insert(buddy2);
        book.insert(buddy3);

        System.out.println(book.toString());
        book.remove(buddy);
        System.out.println(book.toString());
    }
}