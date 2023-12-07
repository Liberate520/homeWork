package ru.gb.family_tree;

import java.io.Serializable;

public class Home implements Serializable {
    private String home;

    public Home(String home){
        this.home = home;
    }

    public String getHome(){
        return home;
    }
}


