package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    private List<Task> localDataSet;
    public OnInteractingWithTaskListener listener;

    public ViewAdapter(List<Task> tasks, OnInteractingWithTaskListener listener) {
        localDataSet = tasks;
        this.listener=listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Task task;
        public View itemView;


        public ViewHolder(@NonNull View view) {
            super(view);
            this.itemView = view;

        }

    }
public static interface OnInteractingWithTaskListener{
    public void taskListener(Task task);
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_task, viewGroup, false);

        final ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.taskListener(viewHolder.task);
            }
        });
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.task = localDataSet.get(position);


        TextView title = viewHolder.itemView.findViewById(R.id.titleView);
        TextView body = viewHolder.itemView.findViewById(R.id.bodyView);
        TextView status = viewHolder.itemView.findViewById(R.id.stateView);


        title.setText(viewHolder.task.title);
        body.setText(viewHolder.task.body);
        status.setText(viewHolder.task.state);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}