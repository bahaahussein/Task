package com.example.android.task.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Professor on 11/15/2018.
 */

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Task(String text) {
        this.text = text;
    }
}
