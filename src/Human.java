

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/** */
public class Human {
    private String name;
    private String surname;
    private LocalDate dateOfBirth ;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Human mother;
    private Human father;
    private ArrayList<Human> children;
    private ArrayList<Human> parents;

    public Human(String name, String surname, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.gender=gender;

    }

    public Human(String name, String surname, LocalDate dateOfBirth, Human mother, Human father, Gender gender) {
        this(name, surname, dateOfBirth, null, mother, father, gender);
    }

    public Human(String name, String surname, LocalDate dateOfBirth, Gender gender) {
        this(name, surname, dateOfBirth, null, null, gender);
    }

    public Human(String name, String surname, LocalDate dateOfBirth) {
        this(name, surname, dateOfBirth, null, null, null);
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void addChildM(Human child) {
        child.mother = this;
        
        children.add(child);
    }
    public void addChildF(Human child) {
        child.father = this;
        children.add(child);
    }



    
    

    @Override
    public String toString() {
        return String.format("Имя, фамилия: %s %s\nДата рождения: %s\n", name, surname, dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    
    
    public ArrayList<Human> getParents() {
        parents = new ArrayList<>();
        if (mother != null) {
            parents.add(mother);
        }
        if (father != null) {
            parents.add(father);
        }
        return parents;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }
    
}
