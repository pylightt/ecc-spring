package xyz.merccurion.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.merccurion.spring.model.Roles;

@Repository
public interface RolesDao extends JpaRepository<Roles, Integer> {
    
}
