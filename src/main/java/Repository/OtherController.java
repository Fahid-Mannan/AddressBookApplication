//package Repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class OtherController {
//
//    @Autowired
//    private AddressBookRepository repository;
//
//    @PostMapping("/create")
//    @ResponseBody
//    public AddressBook createAddressBookAPI() {
//        AddressBook book = new AddressBook();
//        repository.save(book);
//        return book;
//    }
//
//    @PostMapping("/add")
//    public AddressBook addBuddyAPI(@RequestParam("bookId") long bookId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNum") long phoneNum) {
//        AddressBook book = repository.findById(bookId);
//        book.insert(new BuddyInfo(name, address, phoneNum));
//        repository.save(book);
//        return book;
//    }
//
//    @PostMapping("/remove")
//    public AddressBook removeBuddyAPI(@RequestParam("bookId") long bookId, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNum") long phoneNum) {
//        AddressBook book = repository.findById(bookId);
//        BuddyInfo buddy = new BuddyInfo(name, address, phoneNum);
//        book.remove(name);
//        repository.save(book);
//        return book;
//    }
//
//    @GetMapping("/get")
//    public AddressBook getBookAPI(@RequestParam("bookId") long bookId) {
//        return repository.findById(bookId);
//    }
//}