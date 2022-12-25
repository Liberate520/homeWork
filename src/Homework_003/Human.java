package Homework_003;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Human implements Serializable, Comparable<Human>{
    private static int startId=0;
    private String name;
    private String date;
    private String gender;
    private int id;
    private HashMap<Integer, Character> relatives = new HashMap<>();

    private Human(int id, String name, String gender, String date, HashMap<Integer, Character> relatives) {
        if (id == 0) {
            this.id = startId++;
        } else {
            this.id = id;
        }
        this.name = name;
        this.gender = gender;
        if (date == null) {
            this.date = "unknown";
        } else {
            this.date = date;
        }

        if (relatives==null) {
            this.relatives = new HashMap<>();
        } else {
            this.relatives = relatives;
        }

    }

    public Human(String name, String gender, String date) {
        this(0, name, gender, date, null);
    }

    public Human(String name, String gender) {
        this(0, name, gender, null, null);
    }

     // ребенок.setParent(родитель)
    // 'p' - родитель, 'с' - ребенок
    public void setParent(Human human) {
        this.relatives.put(human.id, 'p');
        human.relatives.put(this.id, 'c');
    }

    public List<Integer> getRelatives(char rel) {
        List<Integer> newRelatives = new ArrayList<>();
        for (Integer key : this.relatives.keySet()) {
            if (rel == this.relatives.get(key)) {
                newRelatives.add(key);
            }
        }
        return newRelatives;
    }

    public Integer getId() {
        return this.id;
    }
    
    private void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    private void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getGender() {
        return gender;
    }
    

    @Override
    public String toString() {
        String str = "id: "+ id +" "+ name + " Пол: " + gender + " , Дата рождения: " + date + " , Родители(id): ";
        if (getRelatives('p').size() == 0) {
            str += "unknown";
        } else {
            str += getRelatives('p');                 
        }
        str += " , Дети(id): ";
        if (getRelatives('c').size() == 0) {
            str += "unknown";
        } else {
            str += getRelatives('c');                 
        }
        return str + "\n";
    }
    
    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
