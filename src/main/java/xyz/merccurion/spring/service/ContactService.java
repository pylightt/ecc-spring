package xyz.merccurion.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.merccurion.spring.dao.ContactDao;
import xyz.merccurion.spring.dao.EmployeeDao;
import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Contact;
import xyz.merccurion.spring.model.Employee;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private final ContactDao contactDao;
    @Autowired
    private final EmployeeDao employeeDao;

    public ContactService(ContactDao contactDao, EmployeeDao employeeDao) {
        this.contactDao = contactDao;
        this.employeeDao = employeeDao;
    }

    public Employee addContact(int employeeId, Contact contact) throws ResourceNotFoundException {
        Employee employee = employeeDao.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee (ID: " + employeeId + " not found."));
        List<Contact> contactList = employee.getContact();
        contactList.add(contact);
        contact.setEmployee(employee);
        employee.setContact(contactList);
        return employeeDao.save(employee);
    }

    public Contact updateContact(int contactId, Contact contact) throws ResourceNotFoundException {
        Contact updatedContact = contactDao.findById(contactId).orElseThrow(() ->
                new ResourceNotFoundException("Contact (ID: " + contactId + " not found."));

        updatedContact.setLandline(contact.getLandline());
        updatedContact.setMobile(contact.getMobile());
        updatedContact.setEmail(contact.getEmail());

        return this.contactDao.save(updatedContact);
    }

    public void deleteContact(int id) {
        contactDao.deleteById(id);
    }






}
