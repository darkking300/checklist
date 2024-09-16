package com.app.checklist.service;

import com.app.checklist.entity.TaskDetails;
import com.app.checklist.repository.TaskRepositry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepositry taskRepositry;

    @Override
    public List<TaskDetails> fetchAllTasks() {
        return taskRepositry.findAll();
    }

    @Override
    public List<TaskDetails> fetchTasksById(long taskId){
        return taskRepositry.findByTaskId(taskId);
    }

    @Override
    public List<TaskDetails> fetchTasksByStatus(int taskStatus) {
        return taskRepositry.findByTaskStatus(taskStatus);
    }

    @Override
    public List<TaskDetails> fetchTasksByPriority(int priority) {
        return taskRepositry.findByTaskPriority(priority);
    }

    @Override
    public TaskDetails saveTask(TaskDetails taskDetails) {
        return taskRepositry.save(taskDetails);
    }

    @Override
    public TaskDetails updateTask(TaskDetails taskDetails, Long id) {
        log.debug("Entering updateTask method");
        List<TaskDetails> taskDetailsList = taskRepositry.findByTaskId(id);
        if(!taskDetailsList.isEmpty()){
            taskDetails.setTaskId(id);
            TaskDetails taskForSaving = taskDetailsList.get(0);
            taskForSaving.setTaskDesc(taskDetails.getTaskDesc());
            taskForSaving.setTaskPriority(taskDetails.getTaskPriority());
            taskForSaving.setTaskStatus(taskDetails.getTaskStatus());
            taskRepositry.save(taskForSaving);
        }
        return taskDetails;
    }

    @Override
    public void deleteTask(Long id) {
         taskRepositry.deleteById(id);
    }
}
