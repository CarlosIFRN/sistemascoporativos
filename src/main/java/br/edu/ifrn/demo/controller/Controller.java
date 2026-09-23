package br.edu.ifrn.labtarefas.controller;
import br.edu.ifrn.labtarefas.model.Tarefa;
import br.edu.ifrn.labtarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/tarefas")
public class Controller {
    @RestController
    @RequestMapping("/tarefas")
    public class TaskController {
        private final TaskService service;
        public TaskController(TaskService service) {
            this.service = service;
        }
        @PostMapping
        public ResponseEntity<TaskResponseDTO> criar(@RequestBody
                                                     TaskRequestDTO dto) {
            TaskResponseDTO criada = service.criar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criada);
        }
        @GetMapping
        public List<TaskResponseDTO> listar() {
            return service.listarTodas();
        }
    }
}