package family_tree.model.human;

import family_tree.model.family_tree.FamilyTreeInterface;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeInterface<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthData;
    private LocalDate deathData;
    private List<Human> parents;//список родителей
    private List<Human> children;//список детей
    private Human spouse;//муж или жена

    public Human(String name, Gender gender, LocalDate birthData, LocalDate deathData,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthData = birthData;
        this.deathData = deathData;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthData) {
        this(name, gender, birthData, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthData,
                 Human father, Human mather) {
        this(name, gender, birthData, null, father, mather);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (deathData == null) {
            return getPeriod(birthData, LocalDate.now());
        } else {
            return getPeriod(birthData, deathData);
        }
    }

    private int getPeriod(LocalDate birthData, LocalDate deathData) {
        // Вычисление возраста
        Period diff = Period.between(birthData, deathData);
        return diff.getYears();
    }


    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthData() {
        return birthData;
    }

    public LocalDate getDeathData() {
        return deathData;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setBirthData(LocalDate birthData) {
        this.birthData = birthData;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
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
//TODO попробовать убрать текст
    public String getSpouseInfo() {
        // имя супруга(и)
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMather();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
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
