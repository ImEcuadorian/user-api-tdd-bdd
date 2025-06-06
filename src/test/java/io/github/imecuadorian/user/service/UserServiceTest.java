package io.github.imecuadorian.user.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private final UserService userService = new UserService();

    @Test
    void shouldReturnFalseWhenUserDoesNotExist() {
        boolean result = userService.existsByEmail("juan@example.com");
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenUserIsRegistered() {
        userService.register("ana@example.com");
        assertTrue(userService.existsByEmail("ana@example.com"));
    }
}
