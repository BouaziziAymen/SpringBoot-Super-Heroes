package com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.service;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.entity.User;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// UserServiceImpl.java
@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
