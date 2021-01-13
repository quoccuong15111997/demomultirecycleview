package com.firstems.demomultirecycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    private List<String> strings;
    public interface ChildClickCallback{
        void onChildClick(int pos, String value);
    }
    private ChildClickCallback childClickCallback;

    public void setChildClickCallback(ChildClickCallback childClickCallback) {
        this.childClickCallback = childClickCallback;
    }

    public ChildAdapter(List<String> strings) {
        this.strings = strings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_child, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(strings.get(position));
        holder.itemView.setOnClickListener(v -> childClickCallback.onChildClick(position, strings.get(position)));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
} 
