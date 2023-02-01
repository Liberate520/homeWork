package Homework_004.model;

import java.util.HashMap;

public class Human extends BaseType {
    private Human(int id, String name, String gender, String date, HashMap<Integer, Character> relatives) {
        super(id, name, gender, date, relatives);
    }

    public Human(String name, String gender, String date) {
        super(0, name, gender, date, null);
    }

    public Human(String name, String gender) {
        super(0, name, gender, null, null);
    }
}