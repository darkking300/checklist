package com.app.checklist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="TASK_DETAILS")
public class TaskDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String taskDesc;
    private int taskStatus; //0: is open; 1 in progress; 2 is completed; 3 is cancelled; 4 is mark to be deleted
    private int taskPriority;//0 is super important and right away; 1 is medium do it soon; 2 is at your own pace
}
