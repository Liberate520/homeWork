package Homework_006.model;

import java.util.HashMap;



public class Pet extends BaseType {
    private Pet(String name, String gender, String date, HashMap<Integer, Character> relatives) {
        super(name, gender, date, relatives);
    }

    public Pet(String name, String gender, String date) {
        super(name, gender, date, null);
    }

    public Pet(String name, String gender) {
        super(name, gender, null, null);
    }
}