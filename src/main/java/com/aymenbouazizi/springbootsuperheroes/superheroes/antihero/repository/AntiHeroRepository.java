package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.repository;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.AntiHero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AntiHeroRepository extends CrudRepository<AntiHero, UUID> {
}
