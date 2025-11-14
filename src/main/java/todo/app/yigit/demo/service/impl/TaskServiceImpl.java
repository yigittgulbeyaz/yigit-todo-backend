package todo.app.yigit.demo.service.impl;

import org.springframework.stereotype.Service;
import todo.app.yigit.demo.dto.TaskResponse;
import todo.app.yigit.demo.model.Task;
import todo.app.yigit.demo.repository.TaskRepository;
import todo.app.yigit.demo.service.TaskService;
import todo.app.yigit.demo.exception.TaskNotFoundException;


import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponse createTask(Task task) {
        Task saved = taskRepository.save(task);
        return toResponse(saved);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return toResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long id, Task request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());

        Task updated = taskRepository.save(task);
        return toResponse(updated);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }


    private TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreated(),
                task.getUpdated()
        );
    }
}
