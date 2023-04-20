package humans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Human implements Serializable {
    private Human mother, father;
    private String firstName, secondName;
    private Gender gender;
    private LocalDate birthDate;
    private List<Human> children;


    public Human(String firstName, String secondName, Human mother,
                 Human father, Gender gender, int birthday, int birthmonth,
                 int birthyear) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.birthDate = LocalDate.of(birthyear, birthmonth, birthday);
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(String firstName, String secondName, Gender gender,
                 int birthday, int birthmonth, int birthyear) {
        this(firstName, secondName, null, null, gender, birthday, birthmonth,
             birthyear);
    }

    public void addParent(Human parent) {
        if (parent.gender.equals(Gender.Male)) {
            if (this.father == null) this.father = parent;
            else System.out.println("Отец уже определен.");
        } else {
            if (this.mother == null) this.mother = parent;
            else System.out.println("Мать уже определена.");
        }
    }

    public void addChild(Human child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            if (this.gender.equals(Gender.Male)) {
                if (child.father == null) child.addParent(this);
            } else if (child.mother == null) child.addParent(this);
        }
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if (this.mother != null) {
            res += this.getMother().getFullName();
        } else res += "неизвестна";
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if (this.father != null) {
            res += this.getFather().getFullName();
        } else res += "неизвестен";
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder str = new StringBuilder();
        str.append("дети: ");
        if (!this.children.isEmpty()) {
            for (Human child : children) {
                str.append(child.getFullName());
                str.append(", ");
            }
        } else str.append("отсутствуют");
        return str.toString();
    }

    public String getRelatives() {
        StringBuilder str = new StringBuilder();
        str.append("Информация о: ");
        str.append(this.getFullName());
        str.append(":\n\t");
        str.append(this.getMotherInfo());
        str.append(", ");
        str.append(this.getFatherInfo());
        str.append(", ");
        str.append(this.getChildrenInfo());
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;
        Human human = (Human) obj;
        return human.getFullName().equals(this.getFullName());
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    public boolean isAnOrhan() {
        return !(this.mother == null || this.father == null);
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        LocalDate now_date = LocalDate.now();
        int age = now_date.getYear() - this.birthDate.getYear();
        if (now_date.getMonthValue() < this.birthDate.getMonthValue() ||
                now_date.getMonthValue() == this.birthDate.getMonthValue() &&
                        now_date.getDayOfMonth() <
                                this.birthDate.getDayOfMonth()) {
            age--;
        }
        return age;
    }
}
