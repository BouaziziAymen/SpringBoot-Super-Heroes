package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.service;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.AntiHero;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.repository.AntiHeroRepository;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.service.AntiHeroService;
import com.aymenbouazizi.springbootsuperheroes.superheroes.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class AntiHeroH2ServiceTest {
    @Autowired
    private AntiHeroRepository repo;
    private AntiHeroService service;
    @BeforeEach
    public void setup() {
        service = new AntiHeroService(repo);
    }

    @Test
    public void shouldAddAntiHero() {
        AntiHero antiHero = new AntiHero();
        antiHero.setFirstName("Eddie");
        antiHero.setLastName("Brock");
        antiHero.setHouse("MCU");
        service.addAntiHero(antiHero);
        Iterable<AntiHero> antiHeroList =
                service.findAllAntiHeroes();
        AntiHero savedAntiHero =
                antiHeroList.iterator().next();
        assertThat(antiHero).isEqualTo(savedAntiHero);
    }
    @Test
    public void shouldUpdateAntiHero() {
        AntiHero antiHero = new AntiHero();
        antiHero.setFirstName("Eddie");
        antiHero.setLastName("Brock");
        antiHero.setHouse("MCU");
        AntiHero savedAntiHero =
                service.addAntiHero(antiHero);
        savedAntiHero.setHouse("San Francisco");
        service.updateAntiHero(savedAntiHero.getId(),
                savedAntiHero);
        AntiHero foundAntiHero =
                service.findAntiHeroById(savedAntiHero.getId());
        assertThat(foundAntiHero.getHouse()).isEqualTo("San Francisco");
    }

}
