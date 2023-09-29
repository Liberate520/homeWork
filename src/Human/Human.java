package Human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
   private long id;
   private String fistName;
   private String lastName;
   private Gender gender;
   private Human mother;
   private Human father;
   private List<Human> children;
   private LocalDate birthDate;
   private LocalDate deathDate;

   public Human(String fistName, String lastName, LocalDate birthDate, LocalDate deathDate, Gender gender, Human mother, Human father) {
        id = -1;
        this.fistName = fistName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String fistName, String lastName, LocalDate birthDate, Gender gender, Human mother, Human father) {
        this(fistName, lastName, birthDate, null, gender, mother, father);
    }

    public Human(String fistName, String lastName, LocalDate birthDate, Gender gender) {
        this(fistName, lastName, birthDate, null, gender, null, null);
    }

    public Human(String fistName, String lastName, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this(fistName, lastName, birthDate, deathDate, gender, null, null);
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public void addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
    }

    public int getAge() {
        if (deathDate == null) {
            return lifePeriod(birthDate, LocalDate.now());
        } else {
            return lifePeriod(birthDate, deathDate);
        }
    }

    private int lifePeriod(LocalDate birthDate, LocalDate deathDate) {
        Period difference = Period.between(birthDate, deathDate);
        return difference.getYears();
    }

    public String getMotherInfo() {
        String res = " Мама: ";
        if (mother != null) {
            res += mother.getFistName() + " " + mother.getLastName();
        } else {
            res += "Нет";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = " Папа: ";
        if (father != null) {
            res += father.getFistName() + " " + father.getLastName();
        } else {
            res += "Нет";
        }
        return res;
    }


    public String toString() {
        return info();
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(" Имя: ").append(fistName);
        sb.append(" Фамилия: ").append(lastName);
        sb.append(" Пол: ").append(gender);
        sb.append(" День рожд: ").append(birthDate);
        sb.append(" Дата смерти: ").append(deathDate);
        sb.append(getMotherInfo()).append(" ");
        sb.append(getFatherInfo()).append(" ");
        return sb.toString();
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
        return human.getId() == getId();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
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

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
    





