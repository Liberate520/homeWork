package pet;

import familyTree.comparators.Group;
import human.Gender;
import human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//public class Pet implements Serializable, Group<Pet> {
public class Pet implements Serializable {

    private  int id;
    private String name;

    private String dateBirth;
    private String dateDeath;

    private Gender gender;
    private Pet father;
    private Pet mother;

    private Human owner;
    private List<Pet> childList;

    public Pet(int id, String name, String surname, Gender gender, String dateBirth, Pet father, Pet mother) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.gender = gender;

        this.father = father;
        this.mother = mother;
        this.childList = new ArrayList<>();
    }

//    @Override
//    public void addHuman(Pet human) {
//
//    }
//
//    @Override
//    public void addPet(Pet pets) {
//
//    }
//
//    @Override
//    public List<Pet> getPetList() {
//        return null;
//    }
//
//    @Override
//    public String getInfo() {
//        return null;
//    }
    public String getName() {
        return name;
    }


    public String getDateBirth() {
        return this.dateBirth;
    }

    public String getDateDeath() {
        return dateDeath;
    }

    public List<Pet> getChildList() {
        return childList;
    }

    public int getAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateBirth, formatter);
        return Period.between(date, currentDate).getYears();

    }
    public int getNumChildren() {
        return childList.size();
    }

    public Gender getGender() {
        return gender;
    }

    public Pet getMother() {
        return mother;
    }

//    @Override
//    public void addChild(Pet human) {
//
//    }

    public Pet getFather() {
        return father;
    }


}
