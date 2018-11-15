package com.example.android.task.view_models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.android.task.database.MyDatabase;
import com.example.android.task.database.entity.Task;

import java.util.List;

/**
 * Created by Professor on 11/15/2018.
 */

public class TaskViewModel extends AndroidViewModel {

    private LiveData<List<Task>> tasks;
    private MyDatabase database;

    public TaskViewModel(Application application) {
        super(application);
        database = MyDatabase.getDatabase(this.getApplication());
        tasks = database.taskDao().load();
    }

    public LiveData<List<Task>> getTasks() {
        return tasks;
    }


    /*
    @Inject
    public TaskViewModel(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public void init(String userId) {
        if (this.task != null) {
            return;
        }
        task = taskRepo.getTask();
    }

    public LiveData<Task> getTask() {
        return this.task;
    }
    */
}
