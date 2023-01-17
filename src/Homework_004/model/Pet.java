package Homework_004.model;

import java.util.HashMap;



public class Pet extends BaseType {
    private Pet(int id, String name, String gender, String date, HashMap<Integer, Character> relatives) {
        super(id, name, gender, date, relatives);
    }

    public Pet(String name, String gender, String date) {
        super(0, name, gender, date, null);
    }

    public Pet(String name, String gender) {
        super(0, name, gender, null, null);
    }
}