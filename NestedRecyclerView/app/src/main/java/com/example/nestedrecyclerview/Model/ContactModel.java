package com.example.nestedrecyclerview.Model;

import android.graphics.Color;

import java.util.Random;

public class ContactModel {
    public String name;
    public String number;

    public ContactModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Character getProfileLetter() {
        return name.charAt(0);
    }

    public static int getColor() {
        Integer[] color = new Integer[3];
        color[0] = Color.RED;
        color[1] = Color.BLACK;
        color[2] = Color.BLUE;
        Random random = new Random();
        return Color.argb(225, random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
