package Homework_006.model;

import java.util.HashMap;

public class Human extends BaseType {
    private Human(String name, String gender, String date, HashMap<Integer, Character> relatives) {
        super(name, gender, date, relatives);
    }

    public Human(String name, String gender, String date) {
        super(name, gender, date, null);
    }

    public Human(String name, String gender) {
        super(name, gender, null, null);
    }
}