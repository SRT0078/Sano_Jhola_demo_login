package com.profile.sajilojhola.staggeredgridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.profile.sajilojhola.R;

import java.util.ArrayList;

public class StaggeredActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<StaggeredPojo> staggeredPojoArrayList;
    StaggeredAdapter staggeredAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered);
        recyclerView = findViewById(R.id.rvStaggeredGridContener);

        staggeredPojoArrayList = new ArrayList<>();
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_coc));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_key_code));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_facebook_logo));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_football));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_flower));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_candey_crush));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_chess));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_communication));

        staggeredAdapter = new StaggeredAdapter(this,staggeredPojoArrayList);
        recyclerView.setAdapter(staggeredAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }
}