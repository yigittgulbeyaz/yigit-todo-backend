
package todo.app.yigit.demo.service.impl;

import org.springframework.stereotype.Service;
import todo.app.yigit.demo.dto.TaskRequest;
import todo.app.yigit.demo.dto.TaskResponse;
import todo.app.yigit.demo.dto.mapper.TaskMapper;
import todo.app.yigit.demo.exception.TaskNotFoundException;
import todo.app.yigit.demo.model.Task;
import todo.app.yigit.demo.repository.TaskRepository;
import todo.app.yigit.demo.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private Task findOrFail(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public TaskResponse createTask(TaskRequest request) {
        Task task = TaskMapper.toEntity(request);
        Task saved = taskRepository.save(task);
        return TaskMapper.toResponse(saved);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return TaskMapper.toResponse(findOrFail(id));
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = findOrFail(id);
        TaskMapper.updateEntity(task, request);
        Task updated = taskRepository.save(task);
        return TaskMapper.toResponse(updated);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = findOrFail(id);
        taskRepository.delete(task);
    }
}
