package todo.app.yigit.demo.service;

import todo.app.yigit.demo.dto.task.TaskRequest;
import todo.app.yigit.demo.dto.task.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(Long id, TaskRequest request);

    void deleteTask(Long id);

}
