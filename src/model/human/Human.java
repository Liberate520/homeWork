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
    private Human mother;
    private Human father;
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

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public Human getMother() {
        return mother;
    }

    @Override
    public Human getFather() {
        return father;
    }

    @Override
    public List<Human> getChildren() {
        return children;
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

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
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
        if (mother != null) {
            motherInfo += mother.getFirstMomName() + " " + mother.getLastMomName();
        } else {
            motherInfo += "неизвестна";
        }
        return motherInfo;
    }

    public String getFatherInfo() {
        String fatherInfo = "";
        if (father != null) {
            fatherInfo += father.getFirstDadName() + " " + father.getLastName();
        } else {
            fatherInfo += "неизвестен";
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
            childrenInfo.append("нет");
        }
        return childrenInfo.toString();
    }

    @Override
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append(getHumanInfo()).append("\n");
        stringBuilder.append(getMotherInfo()).append(", ");
        stringBuilder.append(getFatherInfo()).append("\n");
        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
    }

    public String getHumanYearsOld() {
        LocalDate date = LocalDate.now();
        Integer yearNow = date.getYear();
        Integer monthNow = date.getMonthValue();
        Integer birthYear = birthDate.getYear();
        Integer birthMonth = birthDate.getMonthValue();
        Integer yearsOld = 0;
        if (deathDate != null) {
            return "Данный человек умер " + deathDate.toString();
        } else {
            if (monthNow < birthMonth) yearsOld = yearNow - birthYear - 1;
            else yearsOld = yearNow - birthYear;
        }
        return yearsOld.toString() + " полных лет";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
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
