package br.edu.ifrn.user.repository;

import br.edu.ifrn.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final Map<Long, User> usuarios = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(sequence.getAndIncrement());
        }
        usuarios.put(user.getId(), user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public boolean deleteById(Long id) {
        return usuarios.remove(id) != null;
    }

    public boolean existsById(Long id) {
        return usuarios.containsKey(id);
    }
}