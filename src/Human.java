import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private LocalDate date;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, LocalDate date, LocalDate deathDate, Gender gender,
                 Human mother, Human father) {
        id = -1;
        this.name = name;
        this.date = date;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, LocalDate date, Gender gender) {
        this(name, date, null, gender, null, null);
    }

    public Human(String name, LocalDate date, Gender gender,
                 Human mother, Human father) {
        this(name, date, null, gender, mother, father);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Female)) setMother(parent);
        else if (parent.getGender().equals(Gender.Male)) setFather(parent);
        return true;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) list.add(father);
        if (mother != null) list.add(mother);
        return list;
    }

    public int getAge() {
        if (deathDate == null) return getPeriod(date, LocalDate.now());
        else return getPeriod(date, deathDate);
    }

    private int getPeriod(LocalDate date, LocalDate deathDate) {
        Period diff = Period.between(date, deathDate);
        return diff.getYears();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder inf = new StringBuilder();
        inf.append("id: ");
        inf.append(id);
        inf.append(", имя: ");
        inf.append(name);
        inf.append(", пол: ");
        inf.append(getGender());
        inf.append(", возраст: ");
        inf.append(getAge());
        inf.append(", ");
        inf.append(getMotherInfo());
        inf.append(", ");
        inf.append(getFatherInfo());
        inf.append(", ");
        inf.append(getChildrenInfo());
        return inf.toString();
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        if (mother != null) res += mother.getName();
        else res += "-";
        return res;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) res += father.getName();
        else res += "-";
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
        } else res.append("-");
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human human)) return false;
        return human.getId() == getId();
    }
}
