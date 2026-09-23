package br.edu.ifrn.user.service;

import br.edu.ifrn.user.dto.UserRequestDTO;
import br.edu.ifrn.user.dto.UserResponseDTO;
import br.edu.ifrn.user.model.User;
import br.edu.ifrn.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO create(UserRequestDTO dto) {
        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setCargo(dto.cargo());
        User saved = userRepository.save(user);
        return toDTO(saved);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<UserResponseDTO> findById(Long id) {
        return userRepository.findById(id).map(this::toDTO);
    }

    public Optional<UserResponseDTO> update(Long id, UserRequestDTO dto) {
        if (!userRepository.existsById(id)) {
            return Optional.empty();
        }
        User user = new User();
        user.setId(id);
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setCargo(dto.cargo());
        User updated = userRepository.save(user);
        return Optional.of(toDTO(updated));
    }

    public boolean delete(Long id) {
        return userRepository.deleteById(id);
    }

    private UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getNome(), user.getEmail(), user.getCargo());
    }
}