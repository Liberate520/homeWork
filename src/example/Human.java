package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


public class Human {

    static Integer counter;
    static {
        counter = 1;
    }
    private final String id;
    //-----------------------------

    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother;

    private Human father;
    private final ArrayList<Human> children;
    {
        children = new ArrayList<>();
    }
    private final ArrayList<Human> brothersAndSisters;
    {
        brothersAndSisters = new ArrayList<>();
        

    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String id, Tree tree) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        if (id.equals("")){
            while (true) {
                boolean flag = false;
                for (int i = 0; i < tree.getExistingIds().size(); i++) {
                    if (Integer.parseInt(new ArrayList<>(Arrays.asList(((String)(tree.getExistingIds().get(i))).split(":")) ).get(1)) == counter) {
                        flag = true;
                    }
                }
                if (flag) {
                    counter++;
                } else {
                    this.id = "id:" + counter;
                    counter = 1;
                    break;
                }
            }
        } else {

            this.id = id;
        }
    }

    public Human(String name, Tree tree){
        this(name, null, LocalDate.now(), null, "", tree);
    }
    //---------------------------------------------------------

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;

    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(Human children) {
        this.children.add(children);
    }

    public ArrayList<Human> getBrothersAndSisters() {
        return brothersAndSisters;
    }

    public void setBrothersAndSisters(Human children) {
        this.brothersAndSisters.add(children);
    }
    //----------------------------------------------------------------------------------
    public static LocalDate creatingADate(String sDate){  // создание даты из строки
        ArrayList<String> dateL = new ArrayList<>(Arrays.asList(sDate.split(" ")));
        return LocalDate.of(Integer.parseInt(dateL.get(2)),
                Integer.parseInt(dateL.get(1)), Integer.parseInt(dateL.get(0)));
    }
}
