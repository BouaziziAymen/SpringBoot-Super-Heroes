package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.repository;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
