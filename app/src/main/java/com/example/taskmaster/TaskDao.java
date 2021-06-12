package com.example.taskmaster;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertAll(Task task);

    @Query("SELECT * FROM Task")
    public List<Task> getAllTasks();

    @Query("SELECT * FROM Task ORDER BY id DESC")
    public List<Task> getAllTasksReversed();

    @Query("SELECT * FROM Task")
    List<Task> getAll();


    @Query("SELECT * FROM Task ")
    List<Task> loadAll();
//
//    @Query("SELECT * FROM Task WHERE title LIKE :first AND " + "state LIKE :state AND " +
//            "body LIKE :last LIMIT 1")
//    Task findByName(String first, String last,String state);
//

//
//    @Delete
//    void delete(Task task);

}
