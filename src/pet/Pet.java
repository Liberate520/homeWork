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
    private List<Pet> childList;
    private Human owner;

    public Pet(int id, String name, Gender gender, String dateBirth, Pet father, Pet mother) {
        this.name = name;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.father = father;
        this.mother = mother;
        this.childList = new ArrayList<>();
    }

    public Pet() {
        this.id = 0;
        this.name = "unknown";
        this.owner = owner;
        this.dateBirth = "unknown";
    }


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



    public Pet getFather() {
        return father;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.name = name;
        }
    }

    public Human getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return this.name +  " " + "Пол: " + getGender() + " " +
                "Возраст: " + getAge() + " лет " + "хозяин" + getOwner() +"\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Pet pet = (Pet) obj;
        return pet.getName().equals(getName());
    }

}
