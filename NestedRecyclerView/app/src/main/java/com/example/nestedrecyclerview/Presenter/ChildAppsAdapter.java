package com.example.nestedrecyclerview.Presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.Model.ChildAppsModel;
import com.example.nestedrecyclerview.R;

import java.util.List;

public class ChildAppsAdapter extends RecyclerView.Adapter<ChildAppsAdapter.ViewHolder> {

    Context context;
    List<ChildAppsModel> childModelClassList;

    public ChildAppsAdapter(List<ChildAppsModel> childModelClassList, Context context) {
        this.context = context;
        this.childModelClassList = childModelClassList;
    }

    @NonNull
    @Override
    public ChildAppsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.child_apps_items, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAppsAdapter.ViewHolder holder, int position) {
        // set the data
        holder.iv_child_image.setImageResource(childModelClassList.get(position).image);
        holder.tvAppName.setText(childModelClassList.get(position).name);
        holder.tvAppStar.setText(childModelClassList.get(position).star);
    }

    @Override
    public int getItemCount() {
        return childModelClassList.size();
    }


    // create the sub class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_child_image;
        TextView tvAppName, tvAppStar;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_child_image = itemView.findViewById(R.id.iv_child_item);
            tvAppName = itemView.findViewById(R.id.tvAppName);
            tvAppStar = itemView.findViewById(R.id.tvStar);
        }
    }
}
