package com.example.nestedrecyclerview.Presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.Model.ParentAppsModel;
import com.example.nestedrecyclerview.R;

import java.util.List;

public class ParentAppsAdapter extends RecyclerView.Adapter<ParentAppsAdapter.ViewHolder> {

    Context context;
    List<ParentAppsModel> parentModelClassList;

    public ParentAppsAdapter(Context context, List<ParentAppsModel> parentModelClassList) {
        this.context = context;
        this.parentModelClassList = parentModelClassList;
    }

    @NonNull
    @Override
    public ParentAppsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.parent_apps_items, null, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ParentAppsAdapter.ViewHolder holder, int position) {
        // set the data
        holder.tv_parent_title.setText(parentModelClassList.get(position).title);
        ChildAppsAdapter childAdapter = new ChildAppsAdapter(parentModelClassList.get(position).childModelClassList, context);
        holder.rv_child.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rv_child.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parentModelClassList.size();
    }

    // create the sub class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv_child;
        TextView tv_parent_title;

        public ViewHolder(View itemView) {
            super(itemView);
            rv_child = itemView.findViewById(R.id.rv_child);
            tv_parent_title = itemView.findViewById(R.id.tv_parent_title);
        }

    }
}
