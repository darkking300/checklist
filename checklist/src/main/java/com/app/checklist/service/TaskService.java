package com.app.checklist.service;

import com.app.checklist.entity.TaskDetails;
import java.util.List;

public interface TaskService {

    public List<TaskDetails> fetchAllTasks();
    public List<TaskDetails> fetchTasksById(long taskId);
    public List<TaskDetails> fetchTasksByStatus(int taskStatus);
    public List<TaskDetails> fetchTasksByPriority(int priority);
    public TaskDetails saveTask(TaskDetails taskDetails);
    public TaskDetails updateTask(TaskDetails taskDetails, Long id);
    public void deleteTask(Long id);
}
