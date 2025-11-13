package todo.app.yigit.demo.service;

import todo.app.yigit.demo.dto.TaskResponse;
import todo.app.yigit.demo.model.Task;
import java.util.List;
public interface TaskService {

    // Create a new task
    TaskResponse createTask(Task task);

    // Return all tasks
    List<TaskResponse> getAllTasks();

    // Find a specific task by ID
    TaskResponse getTaskById(Long id);

    // Update an existing task
    TaskResponse updateTask(Long id, Task updatedTask);

    // Delete a task by ID
    void deleteTask(Long id);
}
