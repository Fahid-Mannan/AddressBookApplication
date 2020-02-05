package Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {
    private long id;
    private String name;
    private String address;
    private long phoneNum;


    public BuddyInfo() {
    }

    public BuddyInfo(String name, String address, long phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public BuddyInfo(BuddyInfo buddy) {
        this.name = buddy.getName();
        this.address = buddy.getAddress();
        this.phoneNum = buddy.getPhoneNum();
    }

    @Id
    @GeneratedValue
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Boolean equals(BuddyInfo buddy) {
        if (this.name.equals(buddy.name) && this.address.equals(buddy.address) && this.phoneNum == buddy.phoneNum) {
            return true;
        }

        return false;
    }

    public String toString() {
        return ("Buddy: " + this.name + " the address: "
                + this.address + " the phone number: "
                + this.phoneNum + ".");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName("Homer");
        System.out.println("Hello " + buddy.getName() + ".");
    }

}