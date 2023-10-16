package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @Autowired
    AddressBookRepository repo;

    @PostMapping("/AddressBook")
    public AddressBook createAddressBook(){
        return repo.save(new AddressBook());
    }

    @PostMapping("/AddressBook/{ID}")
    public AddressBook addBuddy(@PathVariable int ID, @RequestBody BuddyInfo mybuddy){
        AddressBook testBook = repo.findById(ID);
        testBook.addBuddy(mybuddy);
        return repo.save(testBook);
    }

}
