package todo.app.yigit.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskRequest(

        @NotBlank(message = "Title cannot be empty")
        @Size(max = 500, message = "Title must be at most 500 characters")
        String title,

        @Size(max = 1000, message = "Description must be at most 1000 characters")
        String description,

        @NotNull(message = "Completed must be provided")
        Boolean completed
) {}
