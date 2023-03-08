package com.example.nestedrecyclerview.Model;

import java.util.List;

public class ParentAppsModel {
    public String title;
    public List<ChildAppsModel> childModelClassList;
    public ParentAppsModel(String title, List<ChildAppsModel> childModelClassList) {
        this.title = title;
        this.childModelClassList = childModelClassList;
    }
}
