package com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.service;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.repository.AntiHeroRepository;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.entity.AntiHero;
import com.aymenbouazizi.springbootsuperheroes.superheroes.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class AntiHeroService {
    private AntiHeroRepository antiHeroRepository;
    public Iterable<AntiHero> findAllAntiHeroes(){
        return antiHeroRepository.findAll();
    }
    public AntiHero findAntiHeroById(UUID id){
        return findOrThrow(id);
    }
    public void removeAntiHeroById(UUID id){
        findOrThrow(id);
        antiHeroRepository.deleteById(id);
    }
    public AntiHero addAntiHero(AntiHero antiHero){
        return antiHeroRepository.save(antiHero);
    }
    public void updateAntiHero(UUID id, AntiHero antiHero){
        findOrThrow(id);
        antiHeroRepository.save(antiHero);
    }
    private AntiHero findOrThrow(final UUID id){
        return antiHeroRepository.findById(id).orElseThrow(()->new NotFoundException("Anti-Hero not found id="+id));
    }
}
