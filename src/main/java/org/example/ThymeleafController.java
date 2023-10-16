package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @Autowired
    AddressBookRepository repo;

    @GetMapping("/AddressBookHTML")
    public String returner(Model model){
        model.addAttribute("addressBook", repo.findById(2));
        return "AddressBookHTML";
    }
}
