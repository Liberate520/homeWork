package family_tree.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human mother, father, spouse;
    private List<Human> childrenList;
    private String name, familyName;
    private long id;


    public Human(Gender gender, String name, String familyName,
                 LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.gender = gender;
        this.name = name;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        childrenList = new ArrayList<>();
        id = -1;
    }

    public Human(Gender gender, String name, String familyName, LocalDate birthDate) {
        this(gender, name, familyName, birthDate, null, null, null);
    }

    public Human(Gender gender, String name, String familyName, LocalDate birthDate, Human father, Human mother) {
        this(gender, name, familyName, birthDate, null, father, mother);
    }

    public Human(Gender gender, String name, String familyName) {
        this(gender, name, familyName, null, null, null, null);
    }


    public boolean addChild(Human child) {
        if (!childrenList.contains(child)) {
            childrenList.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }


    public Human getFather() {
        return father;
    }

    public boolean haveFather(Human human) {
        return human.getFather() != null;
    }

    public Human getMother() {
        return mother;
    }

    public boolean haveMother(Human human) {
        return human.getMother() != null;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildrenList() {
        return childrenList;
    }

    public List<Human> getParentsList() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    private int getPeriod(LocalDate date1, LocalDate date2) {
        Period diff = Period.between(date1, date2);
        return diff.getYears();
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", Пол: ");
        sb.append(getGender());
        sb.append(", Имя: ");
        sb.append(getName());
        sb.append(", Фамилия: ");
        sb.append(getFamilyName());
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName() + " " + spouse.getFamilyName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName() + " " + mother.getFamilyName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName() + " " + father.getFamilyName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!childrenList.isEmpty()) {
            res.append(childrenList.get(0).getName());
            for (int i = 1; i < childrenList.size(); i++) {
                res.append(", ");
                res.append(childrenList.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
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
}
