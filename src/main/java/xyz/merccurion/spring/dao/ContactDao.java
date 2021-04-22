package xyz.merccurion.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.merccurion.spring.model.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Integer> {
    Page<Contact> findByEmployeeId(int employeeId, Pageable pageable);
}
