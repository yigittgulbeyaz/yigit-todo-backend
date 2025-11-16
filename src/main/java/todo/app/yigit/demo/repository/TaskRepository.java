package todo.app.yigit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.app.yigit.demo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}

