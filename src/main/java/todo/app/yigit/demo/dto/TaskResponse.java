package todo.app.yigit.demo.dto;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        boolean completed,
        LocalDateTime created,
        LocalDateTime updated
) {}
