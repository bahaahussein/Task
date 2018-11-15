package com.example.android.task.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.android.task.database.dao.TaskDao;
import com.example.android.task.database.entity.Task;

/**
 * Created by Professor on 11/15/2018.
 */

@Database(entities = {Task.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase INSTANCE;

    public static MyDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "task_db")
                            .build();
        }
        return INSTANCE;
    }

    public abstract TaskDao taskDao();
}