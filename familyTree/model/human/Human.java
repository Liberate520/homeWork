package familyTree.model.human;

import familyTree.model.group.GroupItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Human implements Comparable<Human>, GroupItem {
    private int id;
    private String surname;
    private String name;

    private Gender gender;
    private String father;
    private String mother;
    private LocalDate dateOfBirthday;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> children;

    public Human(int id, String surname, String name, LocalDate dateOfBirthday, LocalDate dateOfDeath, String father, String mother) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
    }

    public int getPeriod(LocalDate dateOfBirthday, LocalDate dateOfDeath) {
        Period period = Period.between(dateOfBirthday, dateOfDeath);
        period = Period.between(dateOfBirthday, dateOfDeath);
        return period.getYears();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(" Фамилия: ");
        sb.append(surname);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(getFatherInfo());
        sb.append(getMotherInfo());
        return sb.toString();
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getFatherInfo() {
        String result = ", Отец: ";
        String father = getFather();
        if (father != "") {
            result += getFather();
        } else {
            result += "неизвестен";
        }
        return result;
    }

    public String getMotherInfo() {
        String result = ", Мать: ";
        String mother = getMother();
        if (mother != "") {
            result += getMother();
        } else {
            result += "неизвестна";
        }
        return result;
    }

    @Override
    public int getAge () {
        if (dateOfDeath == null){
            return getPeriod(dateOfBirthday, LocalDate.now());
        } else {
            return getPeriod(dateOfBirthday, dateOfDeath);
        }
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
