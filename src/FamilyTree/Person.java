package src.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;

public class Person extends FTObjects implements Serializable{
    private String name;
    private Integer birthDay;
    private Integer deathDay;
    private Sex sex;
    private Integer generation;
    private ArrayList<String> spouseName;
    private ArrayList<String> childrenName;
    private String additionalField;


    public Person(String name, Integer birthDay, Integer deathDay,
                  Sex sex, Integer generation, String additionalField ) {
        this(name, birthDay, deathDay, sex, generation);
        this.additionalField = additionalField;
    }

    public Person(String name, Integer birthDay, Integer deathDay,
                  Sex sex, Integer generation) {
        this.name = name;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.sex = sex;
        this.generation = generation;
        spouseName = new ArrayList<String>();
        childrenName = new ArrayList<String>();
    }

    public void addChild(String child){
        if(!childrenName.contains(child)){
            childrenName.add(child);
            System.out.printf("The child: %s added to person: %s\n",child, name);
        }
        else System.out.printf("There is already such a record: %s\n",child);
    }
    public void childrenlist(){
        if(childrenName.isEmpty()) System.out.println("There are no children");
        else {
            System.out.printf("Children of the person %s :\n",name);
            System.out.println(childrenName);
        }
    }
    public void addSposeName(String spose) {
        if (!spouseName.contains(spose)) {
            spouseName.add(spose);
            System.out.printf("The spose: %s added to person: %s\n", spose, name);
        }
        else System.out.printf("There is already such a record: %s\n", name);
        }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Integer deathDay) {
        this.deathDay = deathDay;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public ArrayList<String> getSpouseName() {
        return spouseName;
    }

    public ArrayList<String> getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName.add(childrenName);
    }

    public String getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(String additionalField) {
        this.additionalField = additionalField;
    }

    @Override
    public String toString() {
        return "Person: " + name + ",\t years of life: " + birthDay + " - " + deathDay +
                ",\t sposes: " + spouseName +
                ",\t children: " + childrenName+
                ",\t generation: " + generation +
                ",\t years of government: " + additionalField;
    }
}
