package todo.app.yigit.demo.dto.mapper;

import todo.app.yigit.demo.dto.TaskRequest;
import todo.app.yigit.demo.dto.TaskResponse;
import todo.app.yigit.demo.model.Task;

public final class TaskMapper {

    private TaskMapper() {}

    // ----------------------------
    // DTO → Entity (Create)
    // ----------------------------
    public static Task toEntity(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setCompleted(request.completed());
        return task;
    }

    // ----------------------------
    // DTO → Entity (Update)
    // ----------------------------
    public static void updateEntity(Task task, TaskRequest request) {
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setCompleted(request.completed());
    }

    // ----------------------------
    // Entity → DTO (Response)
    // ----------------------------
    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
