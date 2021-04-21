package xyz.merccurion.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Contact;
import xyz.merccurion.spring.model.Employee;
import xyz.merccurion.spring.service.ContactService;

@RestController
@RequestMapping("api/contact")
public class ContactController {

    @Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/add/{employeeId}")
    public ResponseEntity<Employee> addContact(@PathVariable("employeeId") int employeeId,
                                               @RequestBody Contact contact) throws ResourceNotFoundException {
        Employee addContactEmployee = contactService.addContact(employeeId, contact);
        return ResponseEntity.ok(addContactEmployee);
    }

    @PutMapping("/updateContact/{contactId}")
    public ResponseEntity<Contact> updateContact(@PathVariable("contactId") int contactId,
                                                 @RequestBody Contact contact) throws ResourceNotFoundException {
        Contact updatedContact = contactService.updateContact(contactId, contact);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("contactId") int contactId) {
        contactService.deleteContact(contactId);
        return new ResponseEntity<>("Contact (ID: " + contactId + ") deleted.", HttpStatus.OK);
    }

}
