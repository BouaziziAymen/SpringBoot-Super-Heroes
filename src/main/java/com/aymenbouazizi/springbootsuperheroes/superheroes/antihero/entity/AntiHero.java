package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="anti_hero_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AntiHero {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="UUID")
    @Column(nullable=false, updatable=false)
    private UUID id;
    @NotNull(message="First name is required")
    private String firstName;
    private String lastName;
    private String house;
    private String knownAs;
    private String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
}
