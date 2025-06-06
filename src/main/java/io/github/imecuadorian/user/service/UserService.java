package io.github.imecuadorian.user.service;

import java.util.HashSet;
import java.util.Set;

public class UserService {
    private final Set<String> registeredEmails = new HashSet<>();

    public boolean existsByEmail(String email) {
        return registeredEmails.contains(email);
    }

    public void register(String email) {
        registeredEmails.add(email);
    }
}
