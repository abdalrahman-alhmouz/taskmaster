package com.example.taskmaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends
        RecyclerView.Adapter<ContactAdapter.ViewHolder>{
    private List<Task> mTask;
    public ContactAdapter(List<Task> tasks) {
        mTask = tasks;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView body;
        public TextView state;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titleHome);
            body = (TextView) itemView.findViewById(R.id.bodyHome);
            state = (TextView) itemView.findViewById(R.id.stateHome);

        }

    }

        @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.fragment_task, parent, false);

            // Return a new holder instance
            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {

//        Task task = mTask.get(position);
//        holder.title.setText(mTask.get(position).getTitle());
//        holder.body.setText(mTask.get(position).getBody());
//        holder.state.setText(mTask.get(position).getState());

    }

    @Override
    public int getItemCount() {
        return mTask.size();
    }
}
