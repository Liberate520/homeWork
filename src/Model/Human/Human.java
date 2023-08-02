package Model.Human;

import Model.FamilyTree.FamilyTree.EntityItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, EntityItem<Human> {
    private String name;
    private List<Human> children;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate deathDate;
    private Status status;
    private Human father;
    private Human mother;
    private Human spouse;

    public Human(String name, LocalDate birthday,
                 Gender gender, Status status,
                 LocalDate deathDate,
                 Human father, Human mother) {
        this.name = name;
        this.birthday = birthday;
        this.deathDate = deathDate;
        if (father != null) {
            this.father = father;
            this.father.setChild(this);
        }
        if (mother != null) {
            this.mother = mother;
            this.mother.setChild(this);
        }
        this.gender = gender;
        this.status = status;
        children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthday,
                 Gender gender, Status status) {
        this(name, birthday, gender, status, null, null, null);
    }

    public Human(String name, LocalDate birthday,
                 Gender gender, Status status, Human father, Human mother) {
        this(name, birthday, gender, status, null, father, mother);
    }

    public void addParents(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
    }

    public boolean setChild(Human ch) {
        if (!(children.contains(ch))) {
            this.children.add(ch);
            return true;
        } else {
            return false;
        }
    }

    public void setChild(List<Human> childrens_s) {
        for (Human child : childrens_s) {
            if (!(children.contains(child))) {
                children.add(child);
            }
        }
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getPeriod(LocalDate birthday, LocalDate deathDate) {
        Period diff = Period.between(birthday, deathDate);
        return diff.getYears();
    }

    public String getAgeToString() {
        StringBuilder st = new StringBuilder();
        if (status.equals(Status.dead)) {
            st.append(", Возраст на момент смерти: ");
            if (!(deathDate == null)) {
                int year = getPeriod(this.birthday, this.deathDate);
                st.append(year);
                st.append(", Дата смерти: ");
                st.append(this.deathDate);
            } else {
                st.append("Неизвестно");
            }
        } else {
            LocalDate date = LocalDate.now();
            int year_d = date.getYear() - birthday.getYear();
            st.append(", Возраст: ");
            st.append(year_d);
        }
        return st.toString();
    }

    public int getAge() {
        int year;
        if (status.equals(Status.dead)) {
            if (deathDate == null) {
                year = 0;
            } else {
                year = getPeriod(this.birthday, this.deathDate);
            }
        } else {
            LocalDate date = LocalDate.now();
            year = date.getYear() - birthday.getYear();
        }
        return year;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return this.name;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", Пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", Дата рождения: ");
        stringBuilder.append(birthday);
        stringBuilder.append(getAgeToString());
        stringBuilder.append(", Статус: ");
        stringBuilder.append(status);
        stringBuilder.append(", Родители: ");
        stringBuilder.append(" Мать: ");
        if (mother == null) {
            stringBuilder.append("неизвестно, ");
        } else {
            stringBuilder.append(mother.getName());
            stringBuilder.append(", ");
        }
        stringBuilder.append(" Отец: ");
        if (father == null) {
            stringBuilder.append("неизвестно, ");
        } else {
            stringBuilder.append(father.getName());
            stringBuilder.append(", ");
        }
        stringBuilder.append("Дети: ");
        StringBuilder childrens = new StringBuilder();
        if (children.size() != 0) {
            for (Human child : children) {
                childrens.append(child.getName());
                childrens.append(", ");
            }
            stringBuilder.append(childrens.toString());
        } else {
            stringBuilder.append("нет, ");
        }
        stringBuilder.append("Партнёр: ");
        if (!(spouse == null)) {
            stringBuilder.append(spouse.getName());
        } else {
            stringBuilder.append("нет.");
        }
        return stringBuilder.toString();

    }

    public void setSpouse(Human spouse) {
        if ((this.spouse == null) || !(this.spouse.equals(spouse))) {
            this.spouse = spouse;
        }
    }
}
