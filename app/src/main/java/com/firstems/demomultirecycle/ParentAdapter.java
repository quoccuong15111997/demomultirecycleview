package com.firstems.demomultirecycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firstems.demomultirecycle.model.ParentModel;

import java.util.ArrayList;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {
    private List<ParentModel> parentModels;

    public ParentAdapter(List<ParentModel> parentModels) {
        this.parentModels = parentModels;
    }
    private ChildAdapter.ChildClickCallback childClickCallback;

    public void setChildClickCallback(ChildAdapter.ChildClickCallback childClickCallback) {
        this.childClickCallback = childClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_parent, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ParentModel parentModel = parentModels.get(position);
        holder.txtTitle.setText(parentModel.getTitle());
        holder.strings.clear();
        holder.strings.addAll(parentModel.getListChild());
        holder.childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parentModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        RecyclerView recyclerView;
        ChildAdapter childAdapter;
        List<String>strings;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.textView2);
            recyclerView = itemView.findViewById(R.id.recycle);
            strings = new ArrayList<>();
            childAdapter = new ChildAdapter(strings);
            childAdapter.setChildClickCallback(childClickCallback);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(childAdapter);
        }
    }
} 
