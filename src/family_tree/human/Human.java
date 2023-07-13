package family_tree.human;

import family_tree.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.Period;
import java.util.*;
import java.time.LocalDate;

public class Human implements FamilyTreeItem<Human> {
    private long id;
    private String firstName, lastName, middleName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother, father;
    private List<Human> children;
    private Gender sex;
    private Human spouse;
    public Human(String firstName, String lastName,
                 String middleName, LocalDate dateOfBirth, LocalDate dateOfDeath,
                 Human mother, Human father,
                 Gender sex) {
        id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        if (mother != null)
            if (mother.getGender() == Gender.female)
                this.mother = mother;
        if (father != null)
            if (father.getGender() == Gender.male)
                this.father = father;

        this.children = new ArrayList<>();

        this.sex = sex;
    }
    public Human(String firstName, String lastName, LocalDate date, Gender sex) {
        this(firstName, lastName, "", date, null, null, null, sex);
    }
    public Human(String firstName, String lastName, String middleName) {
        this(firstName, lastName, middleName, null, null, null,null, null);
    }

    public Human() {
        this("", "", "", LocalDate.of(2100,12,10), null, null, null, Gender.male);

    }
    public void setChildren(ArrayList<Human> child) {
        for (Human human : child) {
            this.children.add(human);
        }
    }
    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }
    public void addFather(Human human) {
        if (human.getGender() == Gender.male)
            this.setFather(human);
    }
    public void addMother(Human human) {
        if (human.getGender() == Gender.female)
            this.setMother(human);
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setFatherAndMother(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
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
        return sex;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setChildren(List<Human> children) {
        for (Human child : children) {
            if (!this.children.contains(child))
                this.children.add(child);
        }
    }
    public void addChildren(Human child) {
        if (!this.children.contains(child))
            this.children.add(child);
    }
    public int getAge() {
        if (dateOfDeath == null)
            return getPeriod(dateOfBirth, LocalDate.now());
        else
            return getPeriod(dateOfBirth, dateOfDeath);

    }
    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period age = Period.between(dateOfBirth, dateOfDeath);
        return age.getYears();
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (this.spouse == null)
            res += "нет";
        else {
            res += spouse.getLastName();
            res += " ";
            res += spouse.getFirstName();
            res += " ";
            res += spouse.getMiddleName();
        }
        return res;
    }
    public String getMotherInfo() {
        String res = "мать: ";
        if (this.getMother() != null) {
            res += this.getMother().getLastName();
            res += " ";
            res += this.getMother().getFirstName();
            res += " ";
            res += this.getMother().getMiddleName();
        }
        else
            res += "неизвестна";
        return res;
    }
    public String getFatherInfo() {
        String res = "отец: ";
        if (this.getFather() != null) {
            res += this.getFather().getLastName();
            res += " ";
            res += this.getFather().getFirstName();
            res += " ";
            res += this.getFather().getMiddleName();
        }
        else
            res += "неизвестен";
        return res;
    }
    public String getChildrenInfo() {
        String res = "дети: ";
        if (this.children != null) {
            for (Human child : children) {
                res += child.getLastName();
                res += " ";
                res += child.getFirstName();
                res += " ";
                res += child.getMiddleName();
                res += ", ";
            }
        }
        else
            res += "отсутствуют";
        return res;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", фамилия: ");
        sb.append(lastName);
        sb.append(", имя: ");
        sb.append(firstName);
        sb.append(", отчество: ");
        sb.append(middleName);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    @Override
    public String toString() {
        return "family_tree.human.Human{" +
                "id=" + id +
                ", имя='" + firstName + '\'' +
                ", фамилия='" + lastName + '\'' +
                ", отчество='" + middleName + '\'' +
                ", рождение=" + dateOfBirth +
                ", смерть=" + dateOfDeath +
                ", мать=" + mother +
                ", отец=" + father +
                ", дети=" + children +
                ", пол=" + sex +
                ", супруг(а)=" + spouse +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Human))
            return false;
        Human human = (Human) obj;
        return human.getId() == this.getId();
    }
}
