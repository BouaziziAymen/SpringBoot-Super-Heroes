package com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.controller;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.dto.ApiResponseDto;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.dto.SignInRequestDto;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.dto.SignUpRequestDto;
import com.aymenbouazizi.springbootsuperheroes.superheroes.antiHero.service.AuthService;
import com.aymenbouazizi.springbootsuperheroes.superheroes.exception.RoleNotFoundException;
import com.aymenbouazizi.springbootsuperheroes.superheroes.exception.UserAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    ResponseEntity<ApiResponseDto<?>> registerUser(@RequestBody @Valid SignUpRequestDto signUpRequestDto) throws UserAlreadyExistsException, RoleNotFoundException {
        return authService.signUpUser(signUpRequestDto);
    }
    @PostMapping("/signin")
    public ResponseEntity<ApiResponseDto<?>> signInUser(@RequestBody @Valid SignInRequestDto signInRequestDto){
        return authService.signInUser(signInRequestDto);
    }

}
