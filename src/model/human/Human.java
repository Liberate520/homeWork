package model.human;

import model.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem<Human> {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String firstMomName;
    private String lastMomName;
    private String firstDadName;
    private String lastDadName;
    private List<Human> children;

    public Human(String firstName, String lastName,
                 LocalDate birthDate, LocalDate deathDate,
                 String firstMomName, String lastMomName,
                 String firstDadName, String lastDadName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.firstMomName = firstMomName;
        this.lastMomName = lastMomName;
        this.firstDadName = firstDadName;
        this.lastDadName = lastDadName;
        children = new ArrayList<>();
    }

    @Override
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public String getFirstMomName() {
        return firstMomName;
    }

    public String getLastMomName() {
        return lastMomName;
    }

    public String getFirstDadName() {
        return firstDadName;
    }

    public String getLastDadName() {
        return lastDadName;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    public String getHumanInfo() {
        String humanInfo = firstName + " " + lastName + " " + birthDate + " ";
        if (deathDate != null) {
            humanInfo += deathDate + " ";
        }
        return humanInfo;
    }

    public String getMotherInfo() {
        String motherInfo = "мать: ";
        if (firstMomName != null && lastMomName != null) {
            motherInfo += firstMomName + " " + lastMomName;
        } else {
            motherInfo += "Неизвестна";
        }
        return motherInfo;
    }

    public String getFatherInfo() {
        String fatherInfo = "отец: ";
        if (firstDadName != null && lastDadName != null) {
            fatherInfo += firstDadName + " " + lastDadName;
        } else {
            fatherInfo += "Неизвестен";
        }
        return fatherInfo;
    }

    public String getChildrenInfo() {
        StringBuilder childrenInfo = new StringBuilder();
        childrenInfo.append("дети: ");
        if (children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                childrenInfo.append(children.get(i).getFirstName()).append(" ");
                childrenInfo.append(children.get(i).getLastName());
                if (i < children.size() - 1) {
                    childrenInfo.append(", ");
                }
            }
        } else {
            childrenInfo.append("Детей нет");
        }
        return childrenInfo.toString();
    }

    @Override
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append(getHumanInfo()).append("\n");
        stringBuilder.append(getHumanYearsOldInfo()).append("\n");
        stringBuilder.append(getMotherInfo()).append(", ");
        stringBuilder.append(getFatherInfo()).append("\n");
        stringBuilder.append(getChildrenInfo()).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String getNotFoundInfo() {
        return "Такого человека в фамильном дереве нет";
    }

    public String getHumanYearsOldInfo() {
        LocalDate date = LocalDate.now();
        Integer yearNow = date.getYear();
        Integer monthNow = date.getMonthValue();
        Integer birthYear = birthDate.getYear();
        Integer birthMonth = birthDate.getMonthValue();
        Integer yearsOld;
        if (deathDate != null) {
            return "Данный человек умер " + deathDate;
        } else {
            if (monthNow < birthMonth) yearsOld = yearNow - birthYear - 1;
            else yearsOld = yearNow - birthYear;
        }
        return yearsOld + yearsMsg(yearsOld);
    }

    public String yearsMsg(Integer yearsOld) {
        if (yearsOld % 10 == 1) {
            return " год";
        } else if (yearsOld > 10 && yearsOld < 20) {
            return " лет";
        } else if (yearsOld % 10 == 2 || yearsOld % 10 == 3 || yearsOld % 10 == 4) {
            return " года";
        } else {
            return " лет";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Human human)) {
            return false;
        }
        if (human.getFirstName().equals(getFirstName())) {
            if (human.getLastName().equals(getLastName())) {
                if (human.getBirthDate() != getBirthDate()) {
                    return false;
                }
            }
        }
        return human.getFirstName().equalsIgnoreCase(getFirstName());
    }

    @Override
    public int compareTo(Human o) {
        return 0;
    }
}
