package ru.gb.dogs;

import ru.gb.node.TreeItem;
import ru.gb.treeItem.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dog implements Serializable, TreeItem<Dog> {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Dog> parents;
    private List<Dog> children;

    public Dog(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Dog father,
                  Dog mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
    public Dog(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name,gender, birthDate, deathDate, null, null);
    }
    public Dog(String name, Gender gender, LocalDate birthDate) {
        this(name,gender, birthDate, null, null, null);
    }

    public Dog(String name, Gender gender, LocalDate birthDate, Dog father,
                  Dog mother) {
        this(name,gender, birthDate, null, father, mother);
    }

    @Override
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateToCalculate = deathDate != null ? deathDate : currentDate;

        int age = dateToCalculate.getYear() - birthDate.getYear();
        if (dateToCalculate.getMonthValue() < birthDate.getMonthValue() ||
                (dateToCalculate.getMonthValue() == birthDate.getMonthValue() &&
                        dateToCalculate.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }

    @Override
    public void addChild(Dog child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addParent(Dog parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }


    public Dog getFather() {
        for (Dog parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Dog getMother() {
        for (Dog parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    @Override
    public List<Dog> getParents() {
        return parents;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public List<Dog> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        Dog mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        Dog father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");

        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    //TODO: если человек умер, указывать это при выводе
}