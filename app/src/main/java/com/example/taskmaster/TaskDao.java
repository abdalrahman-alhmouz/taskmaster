package com.example.taskmaster;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    public void saveTask(TaskTable taskTable);

    @Query("SELECT * FROM TaskTable")
    public List<TaskTable> getAllTasks();

    @Query("SELECT * FROM TaskTable ORDER BY id DESC")
    public List<TaskTable> getAllTasksReversed();



}
