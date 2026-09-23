package br.edu.ifrn.user.controller;

import br.edu.ifrn.demo.dto.user.UserRequestDTO;
import br.edu.ifrn.user.dto.UserResponseDTO;
import br.edu.ifrn.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import  br.edu.ifrn.user.model;

import java.util.List;

public class UserController {
    @RestController
    @RequestMapping("/User")
    private final UserService service;
        public User(UserService service) {
            this.service = service;
        }

        public ResponseEntity<UserResponseDTO> criar(UserRequestDTO dto) {
            UserResponseDTO criada = service.criar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criada);
        }
        public List<UserResponseDTO> listar() {
            return service.listarTodas();
        }

        public UserResponseDTO buscar(UserResponseDTO){
            UserResponseDTO buscar = service.buscar(dto);
            return ResponseEntity.status(HttpStatus.).body();
        }
}
