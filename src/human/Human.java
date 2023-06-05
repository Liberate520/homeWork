package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String firstName, String lastName,
                 LocalDate birthDate, LocalDate deathDate,
                 Human mother, Human father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
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
            motherInfo += mother.getFirstName() + " " + mother.getLastName();
        } else {
            motherInfo += "неизвестна";
        }
        return motherInfo;
    }

    public String getFatherInfo() {
        String fatherInfo = "";
        if (father != null) {
            fatherInfo += father.getFirstName() + " " + father.getLastName();
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

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(getHumanInfo()).append("\n");
        sb.append(getMotherInfo()).append(", ");
        sb.append(getFatherInfo()).append("\n");
        sb.append(getChildrenInfo());
        return sb.toString();
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
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
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
