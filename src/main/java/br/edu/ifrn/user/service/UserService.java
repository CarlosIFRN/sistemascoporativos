package br.edu.ifrn.user.service;
import br.edu.ifrn.labtarefas.model.Tarefa;
import br.edu.ifrn.labtarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    private final TarefaRepository repository;
    public UserService(TarefaRepository repository) {
        this.repository = repository;
    }
    public TaskResponseDTO criar(TaskRequestDTO dto) {
        Task tarefa = new Tarefa()Task(dto.titulo(), dto.descricao(), dto.prazo());
        Task salva = repository.salvar(tarefa);
        return toResponseDTO(salva);
    }
    public List<TaskResponseDTO> listarTodas() {
        return repository.listarTodas().stream()
                .map(this::toResponseDTO)
                .toList();
    }
    private TaskResponseDTO toResponseDTO(Task tarefa) {
        return new TaskResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.isConcluida(),
                tarefa.getPrioridade()
        );
    }
}