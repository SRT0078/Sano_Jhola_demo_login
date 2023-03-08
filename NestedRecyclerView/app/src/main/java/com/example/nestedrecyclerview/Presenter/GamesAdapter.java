package com.example.nestedrecyclerview.Presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.Model.GameModel;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {

    Context context;
    ArrayList<GameModel> gameModelArrayList;

    public GamesAdapter(Context context, ArrayList<GameModel> gameModelArrayList) {
        this.context = context;
        this.gameModelArrayList = gameModelArrayList;
    }

    @NonNull
    @Override
    public GamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.game_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesAdapter.ViewHolder holder, int position) {
        holder.ivImage.setImageResource(gameModelArrayList.get(position).image);
        holder.tvName.setText(gameModelArrayList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return gameModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_gamesLogo);
            tvName = itemView.findViewById(R.id.tv_gameName);
        }
    }
}
