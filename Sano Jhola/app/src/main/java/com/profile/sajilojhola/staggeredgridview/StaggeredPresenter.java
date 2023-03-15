package com.profile.sajilojhola.staggeredgridview;

import com.example.myapplication.R;

import java.util.ArrayList;

public class StaggeredPresenter {

//    ArrayList<StaggeredPojo> staggeredPojoArrayList;

    public void staggeredGridView(ArrayList<StaggeredPojo> staggeredPojoArrayList){
        staggeredPojoArrayList = new ArrayList<>();
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_coc));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_key_code));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_facebook_logo));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_football));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_candey_crush));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_chess));
        staggeredPojoArrayList.add(new StaggeredPojo(R.mipmap.img_communication));
    }
}
