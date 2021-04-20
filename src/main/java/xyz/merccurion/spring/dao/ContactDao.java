package xyz.merccurion.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.merccurion.spring.model.Employee;

public interface ContactDao extends JpaRepository<Employee, Integer> {

}
