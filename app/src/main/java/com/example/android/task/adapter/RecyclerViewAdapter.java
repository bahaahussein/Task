package com.example.android.task.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.task.R;
import com.example.android.task.database.entity.Task;

import java.util.List;

/**
 * Created by Professor on 11/15/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Task> tasksList;

    public RecyclerViewAdapter(List<Task> tasksList) {
        this.tasksList = tasksList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Task task = tasksList.get(position);
        holder.taskTextView.setText(task.getText());
    }

    @Override
    public int getItemCount() {
        return tasksList==null? 0 : tasksList.size();
    }

    public void addItems(List<Task> tasksList) {
        this.tasksList = tasksList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView taskTextView;

        RecyclerViewHolder(View view) {
            super(view);
            taskTextView = (TextView) view.findViewById(R.id.task_text);
        }
    }
}
