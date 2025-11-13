package todo.app.yigit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.app.yigit.demo.model.Task;

/**
 * Repository interface for Task entities.
 * Provides basic CRUD operations via JpaRepository.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Custom queries can be added later, for example:
    // List<Task> findByCompleted(boolean completed);
    // List<Task> findByTitleContaining(String keyword);
}
