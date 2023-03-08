package com.example.nestedrecyclerview.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nestedrecyclerview.Model.GameModel;
import com.example.nestedrecyclerview.Presenter.GamesAdapter;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;

public class GamesFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<GameModel> gameModelArrayList;
    View gameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return gameView = inflater.inflate(R.layout.fragment_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceSated) {
        super.onViewCreated(view, savedInstanceSated);

        recyclerView = gameView.findViewById(R.id.rv_gamesContent);
        gameModelArrayList = new ArrayList<>();
        gameModelArrayList.add(new GameModel(R.mipmap.img_coc, "COC"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_candy_crush, "CANDY CRUSH"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_chess, "CHESS"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_pubg, "PUBG"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_car_race, "CAR RACE"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_ludo, "LUDO"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_free_fire, "FREE FIRE"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_card, "Card"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_football, "FOOTBALL"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_coc, "COC"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_coc, "COC"));
        gameModelArrayList.add(new GameModel(R.mipmap.img_coc, "COC"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        GamesAdapter gamesAdapter = new GamesAdapter(getActivity(), gameModelArrayList);
        recyclerView.setAdapter(gamesAdapter);
    }


}