package units;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Unit implements Serializable {
    private Unit mother, father;
    private String firstName;
    private Gender gender;
    private LocalDate birthDate;
    private List<Unit> children;

    public Unit(String firstName, Unit mother, Unit father, Gender gender,
                int birthday, int birthmonth, int birthyear) {
        this.firstName = firstName;
        this.gender = gender;
        this.birthDate = LocalDate.of(birthyear, birthmonth, birthday);
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public void addParent(Unit parent) {
        if (parent.gender.equals(Gender.Male)) {
            if (this.father == null) this.father = parent;
            else System.out.println("Отец уже определен.");
        } else {
            if (this.mother == null) this.mother = parent;
            else System.out.println("Мать уже определена.");
        }
    }

    public void addChild(Unit child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            if (this.gender.equals(Gender.Male)) {
                if (child.father == null) child.addParent(this);
            } else if (child.mother == null) child.addParent(this);
        }
    }

    public Unit getFather() {
        return father;
    }

    public Unit getMother() {
        return mother;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if (this.mother != null) {
            res += this.getMother().getName();
        } else res += "неизвестна";
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if (this.father != null) {
            res += this.getFather().getName();
        } else res += "неизвестен";
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder str = new StringBuilder();
        str.append("дети: ");
        if (!this.children.isEmpty()) {
            for (Unit child : children) {
                str.append(child.getName());
                str.append(", ");
            }
        } else str.append("отсутствуют");
        return str.toString();
    }

    public String getRelatives() {
        StringBuilder str = new StringBuilder();
        str.append("Информация о: ");
        str.append(this.getName());
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
        if (!(obj instanceof Unit)) return false;
        Unit unit = (Unit) obj;
        return unit.getName().equals(this.getName());
    }

    public String getName() {
        return firstName;
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
