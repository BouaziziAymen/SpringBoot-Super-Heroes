package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.repository;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.ERole;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
