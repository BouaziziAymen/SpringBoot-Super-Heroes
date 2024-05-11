package com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.repository;

import com.aymenbouazizi.springbootsuperheroes.superheroes.antihero.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void itShouldCheckWhenUserEmailExists() {
// give
        String email = "seiji@gmail.com";
        User user = User.builder().email(email).password("21398732478").build();
        userRepository.save(user);
// when
        boolean expected = userRepository.existsByEmail(email);
// then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldFindUserWhenEmailExists() {
// give
        String email = "dennis@gmail.com";
        User user = User.builder().email(email).password("21398732478").build();
        userRepository.save(user);
// when
        User expected = userRepository.findByEmail(email).get();
// then
        assertThat(expected).isEqualTo(user);
    }

}
