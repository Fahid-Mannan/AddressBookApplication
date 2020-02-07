package Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherController {

    @Autowired
    private AddressBookRepository repository;

    @PostMapping("/create")
    public AddressBook createAddressBook() {
        AddressBook book = new AddressBook();
        repository.save(book);
        return book;
    }

    @PostMapping("/add")
    public AddressBook addBuddy(@RequestParam("bookId") long bookId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNum") long phoneNum) {
        AddressBook book = repository.findById(bookId);
        book.insert(new BuddyInfo(name, address, phoneNum));
        repository.save(book);
        return book;
    }

    @PostMapping("/remove")
    public AddressBook removeBuddy(@RequestParam("bookId") long bookId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNum") long phoneNum) {
        AddressBook book = repository.findById(bookId);
        BuddyInfo buddy = new BuddyInfo(name, address, phoneNum);
        book.remove(name);
        repository.save(book);
        return book;
    }
}