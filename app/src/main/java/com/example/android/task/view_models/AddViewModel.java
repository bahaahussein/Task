package com.example.android.task.view_models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import com.example.android.task.database.MyDatabase;
import com.example.android.task.database.entity.Task;

/**
 * Created by Professor on 11/15/2018.
 */

public class AddViewModel extends AndroidViewModel {
    private MyDatabase database;
    public AddViewModel(Application application) {
        super(application);

        database = database.getDatabase(this.getApplication());

    }

    public void addTask(final Task task) {
        new addAsyncTask(database).execute(task);
    }

    private static class addAsyncTask extends AsyncTask<Task, Void, Void> {

        private MyDatabase db;

        addAsyncTask(MyDatabase database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final Task... params) {
            db.taskDao().save(params[0]);
            return null;
        }

    }
}
