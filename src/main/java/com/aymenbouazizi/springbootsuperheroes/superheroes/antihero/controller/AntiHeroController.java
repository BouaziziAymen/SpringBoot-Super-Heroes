package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.controller;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.dto.AntiHeroDto;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.AntiHero;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.service.AntiHeroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/superheroes")
@Slf4j
public class AntiHeroController {
    private final AntiHeroService antiHeroService;
    private final ModelMapper modelMapper;
    @GetMapping("/{id}")
public AntiHeroDto getAntiHeroById(@PathVariable("id") UUID id){
        var entity = antiHeroService.findAntiHeroById(id);
        return convertToDto(entity);
    }
    @PutMapping("/{id}")
public void putAntiHero(@PathVariable("id") UUID id,@Valid @RequestBody AntiHeroDto dto){
        if(!id.equals(dto.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid id");
        }
        var antiHero = convertToEntity(dto);
        antiHeroService.updateAntiHero(id,antiHero);
    }
    @DeleteMapping("/{id}")
    public void deleteAntiHeroById(@PathVariable("id") UUID id){
        antiHeroService.removeAntiHeroById(id);
    }
    @GetMapping
    @CrossOrigin
    public List<AntiHeroDto> getAntiHeroes(Pageable pageable){
        int toSkip = pageable.getPageSize()*pageable.getPageNumber();
        //SLF4J
        log.info("Using SLF4J: Getting anti hero list - getAntiHeroes()");
       var antiHeroList = StreamSupport.stream(antiHeroService.findAllAntiHeroes().spliterator(),false)
               .skip(toSkip).limit(pageable.getPageSize()).toList();
        return antiHeroList.stream().map(this::convertToDto).toList();
    }

    @PostMapping
    public AntiHeroDto postAntiHero(@Valid @RequestBody AntiHeroDto antiHeroDto){
        var entity = convertToEntity(antiHeroDto);
        var antiHero = antiHeroService.addAntiHero(entity);
        return convertToDto(antiHero);
    }
    private AntiHeroDto convertToDto(AntiHero entity){
        return modelMapper.map(entity, AntiHeroDto.class);
    }
    private AntiHero convertToEntity(AntiHeroDto dto){
        return modelMapper.map(dto,AntiHero.class);
    }
}
