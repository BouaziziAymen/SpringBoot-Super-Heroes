package com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.repository;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.entity.ERole;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
