package todo.app.yigit.demo.service;

import todo.app.yigit.demo.dto.TaskRequest;
import todo.app.yigit.demo.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(Long id, TaskRequest request);

    void deleteTask(Long id);

}
