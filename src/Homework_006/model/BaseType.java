package Homework_006.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseType implements Serializable, Comparable<BaseType> {
    protected String name;
    protected String date;
    protected String gender;
    protected int id;
    protected HashMap<Integer, Character> relatives = new HashMap<>();

    protected BaseType(String name, String gender, String date, HashMap<Integer, Character> relatives) {
        this.id = 0;
        this.name = name;
        this.gender = gender;
        if (date == null) {
            this.date = "Нет данных";
        } else {
            this.date = date;
        }

        if (relatives == null) {
            this.relatives = new HashMap<>();
        } else {
            this.relatives = relatives;
        }

    }

    protected BaseType(String name, String gender, String date) {
        this(name, gender, date, null);
    }

    protected BaseType(String name, String gender) {
        this(name, gender, null, null);
    }

    // ребенок.setParent(родитель)
    // 'p' - родитель, 'с' - ребенок
    public void setParent(BaseType ex) {
        this.relatives.put(ex.getId(), 'p');
        ex.relatives.put(this.id, 'c');
    }

    public List<Integer> getRelativesIds(char rel) {
        List<Integer> relativesIds = new ArrayList<>();
        for (Integer key : this.relatives.keySet()) {
            if (rel == this.relatives.get(key)) {
                relativesIds.add(key);
            }
        }
        return relativesIds;
    }

    public void setId(int id) {
        this.id = id;
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
        String str = "id: " + id + " " + name + " Пол: " + gender + " , Дата рождения: " + date + " , Родители(id): ";
        if (getRelativesIds('p').size() == 0) {
            str += "Нет данных";
        } else {
            str += getRelativesIds('p');
        }
        str += " , Дети(id): ";
        if (getRelativesIds('c').size() == 0) {
            str += "Нет данных";
        } else {
            str += getRelativesIds('c');
        }
        return str + "\n";
    }

    @Override
    public int compareTo(BaseType o) {
        return name.compareTo(o.name);
    }
}
