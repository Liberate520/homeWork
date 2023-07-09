package familyTree.src.family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
public class Human {
    private String docId;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private String spouse;

    public Human(String docId, String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother, String spouse) {
        this.docId = docId;
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
        this.spouse = spouse;
    }

    public Human(String docId, String name, Gender gender, LocalDate birthDate) {
        this(docId, name, gender, birthDate, null, null, null, null);
    }

    public Human(String docId, String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(docId, name, gender, birthDate, null, father, mother, null);
    }

    public Human(String docId, String name, Gender gender, LocalDate birthDate, String spouse) {
        this(docId, name, gender, birthDate, null, null, null, spouse);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getDocId() {
        return docId;
    }

    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            children.add(parent);
            return true;
        }
        return false;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public List<Human> getParents() {
        return parents;
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

    public Gender getGender() {
        return gender;
    }
    public String getSpouse() {
        String res = "семейное положение (документ супруга): ";
        if(spouse !=null) {
            res += spouse;
        } else {
            if(getGender() == Gender.Female) {
                res += "не замужем";
            } else {
                res += "холост";
            }
        }
        return res;
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("документ id: ");
        sb.append(docId);
        sb.append("имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        sb.append(", ");
        sb.append(getSpouse());
        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if(mother !=null) {
            res += mother.getDocId();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if(father !=null) {
            res += father.getDocId();
        } else {
            res += "неизвестен";
        }
        return res;
    }
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size() != 0) {
            res.append(children.get(0).getDocId());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getDocId());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }
    public int getAge(){
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getDocId().equals(getDocId());
    }
}
