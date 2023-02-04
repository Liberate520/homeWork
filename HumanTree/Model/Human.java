package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human  implements Comparable<Human>, Serializable {
    private String name;
    private String years_of_life;
    private String years_of_reign;
    private Human father;
    private Human mother;
    private List<Human> child;
    
    public Human(String name, String years_of_life, String years_of_reign, Human father, Human mother) {
        this.name = name;
        this.years_of_life = years_of_life;
        this.years_of_reign = years_of_reign;
        this.father = father;
        this.mother = mother;
        child = new ArrayList<>();        
    }

    public String getName() {
        return name;
    }
    
    public String getYears_of_reign() {
        return years_of_reign;
    }

    public Integer getBirth() {
        int getYear = 0;
        String [] years = years_of_life.split("");
        Integer [] yearBirth = new Integer [4];
        for (int i = 0; i < yearBirth.length; i++) {
            yearBirth[i] = Integer.parseInt(years[i]);
            getYear = 10 * getYear + yearBirth[i];
        }        
        return getYear;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void getChild() {
        System.out.println(child);
    }

    public boolean addChild(Human humanChild) {
        if (!child.contains(humanChild)){
            child.add(humanChild);
            return true;
        }
        else return false;
    }
    public List<Human> getSistBroth() {
        List<Human> res = new ArrayList<>();
        for (Human h: this.getFather().child){
            if (!h.getName().equals(this.getName())){
                res.add(h);
            }
        }
        return res;
    }
  
    @Override
    public String toString() {
        return "Human{" +
                "Name: '" + name + '\'' +
                ", years of life: " + years_of_life +
                ", years of reign: " + years_of_reign +
                '}';
    }

    @Override
    public int compareTo(Human o) {        
        return name.compareTo(o.name);
    }
}
