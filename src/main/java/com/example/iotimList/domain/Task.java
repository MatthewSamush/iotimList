package com.example.iotimList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String task;
    private String status;

    public Task() {
    }

    public Task(String task, String status) {
        this.task = task;
        this.status = status;
    }

    public void setTask(String task){
        this.task = task;
    }

    public String getTask(){
        return task;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return status;
    }

    public void setTag(String status) {
        this.status = status;
    }
}
