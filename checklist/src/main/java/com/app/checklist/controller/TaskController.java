package com.app.checklist.controller;

import ch.qos.logback.core.CoreConstants;
import com.app.checklist.entity.TaskDetails;
import com.app.checklist.service.TaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task/all")
    public List<TaskDetails> getAllTasks(){
        return taskService.fetchAllTasks();
    }
/*
    @GetMapping("/task/foos")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
    }
*/
    @GetMapping("/task/byId")
    @ResponseBody
    public List<TaskDetails> getAllTasksById(@RequestParam String id){
        return taskService.fetchTasksById(Long.parseLong(id));
    }

    @GetMapping("/task/byStatus")
    public List<TaskDetails> getAllTasksByStatus(@RequestParam String status){
        return taskService.fetchTasksByStatus(Integer.parseInt(status));
    }

    @GetMapping("/task/byPriority")
    public List<TaskDetails> getAllTasksByPriority(@RequestParam String priority){
        return taskService.fetchTasksByPriority(Integer.parseInt(priority));
    }

    @PostMapping(value = "/task/new" , consumes="application/json")
    public int saveTask(@Validated @RequestBody TaskDetails taskDetails){
        try{
            taskService.saveTask(taskDetails);
        }catch(Exception e){
            log.error("Error occurred while saving task!{}", e.getMessage());
            return 1;
        }
        return 0;
    }

    @PutMapping(value = "/task/update", consumes="application/json")
    public int updateTask(@RequestBody TaskDetails taskDetails, @RequestParam String id){
        try{
            log.debug("Entering update flow!");
            System.out.println(taskDetails.toString());
            System.out.println(id);
            taskService.updateTask(taskDetails, Long.parseLong(id));
        }catch(Exception e){
            log.error("Error occurred while updating task!{}", e.getMessage());
            return 1;
        }
        return 0;
    }

    @PostMapping("/task/delete")
    public int deleteTask(@RequestParam String id){
        try{
            taskService.deleteTask(Long.parseLong(id));
        }catch(Exception e){
            log.error("Error occurred while deleting task!{}", e.getMessage());
            return 1;
        }
        return 0;
    }

}
