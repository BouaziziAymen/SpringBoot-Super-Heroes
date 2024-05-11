package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.dto;
import lombok.Builder;
import lombok.Data;
import java.util.List;
@Data
@Builder
public class SignInResponseDto {
    private Long id;
    private String username;
    private String email;
    private String token;
    private String type;
    private List<String> roles;
}
