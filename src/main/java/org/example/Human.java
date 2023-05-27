package org.example;

import java.util.List;

public class Human {
    Human father;
    Human mother;
    List<Human> childrenList;
    private String birdthday;
    private int height;
    private String rase;
    List<Human> humanList;
    private String name;

    public void addHuman(Human human){
        humanList.add(human);
    }

    public Human(String name, String birdthday, int height, String rase) {
        this.birdthday = birdthday;
        this.height = height;
        this.rase = rase;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name = '" + name + '\'' +
                ", birdthday = '" + birdthday + '\'' +
                ", height = " + height +
                ", rase = '" + rase + '\'' +
                '}';
    }
}
