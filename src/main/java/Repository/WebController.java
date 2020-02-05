package Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    @Autowired
    private AddressBookRepository repository;

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", repository.findAll());
        return "webController";
    }
}