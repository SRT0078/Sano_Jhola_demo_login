package com.profile.sajilojhola.Activity;

public class UserData {
    String username;
    String password;
    float number;

    // create the getter methods where accept the single parameter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public float setPhoneNumber(){
        return number;
    }

    // create the setter methods where return the values
    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPhoneNumber(float number){
        this.number = number;
    }

}
