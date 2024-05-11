package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.service;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.AntiHero;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.repository.AntiHeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AntiHeroServiceTest {
    @Mock
    private AntiHeroRepository antiHeroRepository;
    @InjectMocks
    private AntiHeroService underTest;

    @Test
    void canAddAntiHero() {
// given
        AntiHero antiHero = new AntiHero(UUID.randomUUID(), "Venom", "Lakandula", "Tondo", "Datu of Tondo", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date()));
// when
        underTest.addAntiHero(antiHero);
// then
        ArgumentCaptor<AntiHero> antiHeroDtoArgumentCaptor = ArgumentCaptor.forClass(AntiHero.class);
        verify(antiHeroRepository).save(antiHeroDtoArgumentCaptor.capture());
        AntiHero capturedAntiHero = antiHeroDtoArgumentCaptor.getValue();
        assertThat(capturedAntiHero).isEqualTo(antiHero);
    }
}
