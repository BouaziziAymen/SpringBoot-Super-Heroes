package com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.repository;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.entity.AntiHero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AntiHeroRepository extends CrudRepository<AntiHero, UUID> {
}
