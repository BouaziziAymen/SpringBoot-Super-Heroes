package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.service;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.ERole;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.Role;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.repository.RoleRepository;
import com.aymenbouazizi.springbootsuperheroes.superheroes.exception.RoleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public Role getRole(String role) throws RoleNotFoundException {
        switch (role) {
            case "admin" -> {
                return roleRepository.findByName(ERole.ROLE_ADMIN);
            }
            case "user" -> {
                return roleRepository.findByName(ERole.ROLE_USER);
            }
            case "super_admin" -> {
                return roleRepository.findByName(ERole.ROLE_SUPER_ADMIN);
            }
            default -> throw  new RoleNotFoundException("No role found for " +  role);
        }
    }

}
