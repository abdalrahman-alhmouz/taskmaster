package com.example.taskmaster;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertAll(Task... task);

    @Query("SELECT * FROM Task")
    public List<Task> getAllTasks();

    @Query("SELECT * FROM Task ORDER BY id DESC")
    public List<Task> getAllTasksReversed();

    @Query("SELECT * FROM Task WHERE title LIKE :title AND " +"state LIKE :state AND " +
            "body LIKE :body LIMIT 1")
    Task findByName(String title,String state, String body);


}