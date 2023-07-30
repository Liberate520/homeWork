package Home_work.Human;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.io.Serializable;
import java.lang.StringBuilder;

import Home_work.Gender.*;

public class Human implements Serializable{
    private Human mother;
    private Human father;
    private String firstName;
    private String birthdays;
    private Gender gender;
    private List<Human> children;
    private LocalDate birthDate;
    private LocalDate deathDate;

    public Human(String firstName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother,
            Human father) {
        this.firstName = firstName;
        this.gender = gender;
        this.mother = mother;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.children = new ArrayList<>();

    }

    public Human(String firstName, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(firstName, gender, birthDate, null, mother, father);

    }

    public Human(String firstName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, gender, birthDate, deathDate, null, null);

    }

    public Human(String firstName, Gender gender, LocalDate birthDate) {
        this(firstName, gender, birthDate, null, null, null);

    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return firstName;
    }

    public String getBirthdays() {
        return birthdays;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirhDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getAgeInfo() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birDate, LocalDate deathDate) {
        Period infoAge = Period.between(birDate, deathDate);
        return infoAge.getYears();
    }

    public String getMotherInfo() {
        String mom;
        if (mother != null) {
            mom = "Mother: " + mother.getName();
        } else {
            mom = "Mother: null";
        }
        return mom;
    }

    public String getFatherInfo() {
        String dad;
        if (father != null) {
            dad = "Father: " + father.getName();
        } else {
            dad = "Father: null";
        }
        return dad;
    }

    public String getChildrenInfo() {
        StringBuilder sbChildren = new StringBuilder();

        if (children.size() != 0) {
            sbChildren.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sbChildren.append(firstName);
            }
        } else {
            sbChildren.append("null");
        }
        return sbChildren.toString();
    }

    public String getInfoHuman() {
        StringBuilder stringBuilderHuman = new StringBuilder();
        stringBuilderHuman.append("Name: ");
        stringBuilderHuman.append(firstName);
        stringBuilderHuman.append(", Age: ");
        stringBuilderHuman.append(getAgeInfo());
        stringBuilderHuman.append(", SEX: ");
        stringBuilderHuman.append(gender);
        stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getFatherInfo());
        stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getMotherInfo());
        stringBuilderHuman.append(", Children: ");
        stringBuilderHuman.append(getChildrenInfo());
        return stringBuilderHuman.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getInfoHuman() == getInfoHuman();
    }

}
