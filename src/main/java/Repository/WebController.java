package Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
    private AddressBookRepository repository;

    @PostMapping("/api/create")
    @ResponseBody
    public AddressBook createAddressBookAPI() {
        AddressBook book = new AddressBook();
        repository.save(book);
        return book;
    }

    @PostMapping("/create")
    public String createAddressBook() {
        AddressBook book = new AddressBook();
        repository.save(book);
        return "createPage";
    }

    @PostMapping("/api/add")
    @ResponseBody
    public AddressBook addBuddyAPI(@RequestParam("bookId") long bookId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNum") long phoneNum) {
        AddressBook book = repository.findById(bookId);
        book.insert(new BuddyInfo(name, address, phoneNum));
        repository.save(book);
        return book;
    }

    @PostMapping("/add")
    public String addBuddy(@RequestParam("bookId") long bookId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNum") long phoneNum) {
        AddressBook book = repository.findById(bookId);
        book.insert(new BuddyInfo(name, address, phoneNum));
        repository.save(book);
        return "addBuddy";
    }

    @PostMapping("/api/remove")
    @ResponseBody
    public AddressBook removeBuddyAPI(@RequestParam("bookId") long bookId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNum") long phoneNum) {
        AddressBook book = repository.findById(bookId);
        BuddyInfo buddy = new BuddyInfo(name, address, phoneNum);
        book.remove(name);
        repository.save(book);
        return book;
    }

    @PostMapping("/remove")
    public String removeBuddy(@RequestParam("bookId") long bookId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNum") long phoneNum) {
        AddressBook book = repository.findById(bookId);
        BuddyInfo buddy = new BuddyInfo(name, address, phoneNum);
        book.remove(name);
        repository.save(book);
        return "removeBuddy";
    }

    @GetMapping("/api/get")
    @ResponseBody
    public AddressBook getBookAPI(@RequestParam("bookId") long bookId) {
        return repository.findById(bookId);
    }

    @GetMapping("/get")
    public String getBook(@RequestParam("bookId") long bookId) {
        return "getBook";
    }
}