package com.example.android.task.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.android.task.database.entity.Task;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Professor on 11/15/2018.
 */

@Dao
public interface TaskDao {
    @Insert(onConflict = REPLACE)
    void save(Task task);

    @Query("SELECT * FROM task")
    LiveData<List<Task>> load();
}
