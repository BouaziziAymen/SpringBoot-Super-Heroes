package com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.seeder;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.entity.ERole;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.entity.Role;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleDataSeeder {
    @Autowired
    private RoleRepository roleRepository;
    @EventListener
    @Transactional
    public void LoadRoles(ContextRefreshedEvent event) {
        List<ERole> roles = Arrays.stream(ERole.values()).toList();

        for(ERole erole: roles) {
            if (roleRepository.findByName(erole)==null) {
                roleRepository.save(new Role(erole));
            }
        }
    }
}
