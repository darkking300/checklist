package com.app.checklist.repository;

import com.app.checklist.entity.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepositry extends JpaRepository<TaskDetails, Long> {
    List<TaskDetails> findByTaskStatus(int taskStatus);
    List<TaskDetails> findByTaskPriority(int taskPriority);
    List<TaskDetails> findByTaskId(Long taskId);
}
