package henryleon.phonebook;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/contacts")
public class PhonebookController {
    public List<Contact> contacts;

    public PhonebookController() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Henry", "Leon", "helg18@gmail.com", 584121234567L));
        contacts.add(new Contact("Alisson", "Leon", "aclm@gmail.com", 584241212121L));
        contacts.add(new Contact("Doris", "Mora", "dmmq@gmail.com", 584261478520L));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List all() {
        return contacts;
    }

    @RequestMapping(value = "/searchByNumber/{number}", method = RequestMethod.GET)
    public List getByNumber(@PathVariable Long number) {
        return contacts.stream().filter(x -> x.getTelefono() == number).collect(Collectors.toList());
    }
}
