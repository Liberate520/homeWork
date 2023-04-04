package human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import familyTree.FamilyTree;

public class Human implements Serializable, Comparable {
    public String name, surname;
    private static Integer HumansCount = 0;
    private Integer humanId;
    private Gender gender;
    private Integer birthYear;
    public Human mother, father;
    private List<Human> childs = new ArrayList<>();
    private List<Human> spouse = new ArrayList<>();

    public Human(String name, String surname, Gender gender, Integer birthYear, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthYear = birthYear;
        this.humanId = ++HumansCount;
        mother.addChild(father, this);
        ;
        this.father = father;
        this.mother = mother;
        this.humanId = HumansCount;
        FamilyTree.humans.add(this);
    }

    public Human(String name, String surname, Gender gender, Integer birthYear) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthYear = birthYear;
        humanId = ++HumansCount;
        FamilyTree.humans.add(this);
    }

    public List<Human> parents() {
        List<Human> parents = new ArrayList<>();
        if (mother != null && father != null) {
            parents.add(father);
            parents.add(mother);
        }
        return parents;
    }

    public List<Human> childs() {
        return this.childs;
    }

    public List<Human> spouse() {
        return spouse;
    }

    public int getId() {
        return this.humanId;
    }

    public List<Human> brotherAndSisters() {
        List<Human> brohersAndSisters = new ArrayList<>();
        try {
            brohersAndSisters = this.father.childs();
            brohersAndSisters.remove(this);
        } catch (Exception e) {
            return brohersAndSisters;
        }
        return brohersAndSisters;
    }

    public List<Human> grandMothers() {
        return grand(Gender.Male);
    }

    public List<Human> grandFathers() {
        return grand(Gender.Female);
    }

    public List<Human> grandChildrens() {
        List<Human> grandChildrens = new ArrayList<>();
        for (Human human : this.childs) {
            grandChildrens.addAll(human.childs);
        }
        return grandChildrens;
    }

    public void addChild(Human motherOrFather, Human child) {
        if (child.father == null && child.mother == null && motherOrFather != child && this != child) {
            motherOrFather.childs.add(child);
            this.childs.add(child);
        }
    }

    public void addSpouse(Human human) {
        if (spouse.isEmpty()) {
            setSpouse(human);
            human.setSpouse(this);
        } else {
            spouse.clear();
            setSpouse(human);
            human.setSpouse(this);
        }
    }

    public HashMap<String, List<Human>> allRelations() {
        HashMap<String, List<Human>> allRelations = new HashMap<>();
        allRelations.put("бабушки", this.grandMothers());
        allRelations.put("дедушки", this.grandFathers());
        allRelations.put("родители", this.parents());
        allRelations.put("братья и сестры", this.brotherAndSisters());
        allRelations.put("дети", this.childs());
        allRelations.put("внуки", this.grandChildrens());
        allRelations.put("супруг", this.spouse());

        return allRelations;

    }

    @Override
    public String toString() {
        return name + " " + surname + " " + Integer.toString(birthYear) + " " + gender;
    }

    private List<Human> grand(Gender gender) {
        List<Human> grands = new ArrayList<>();
        try {
            grands = this.father.parents();
            grands.addAll(this.mother.parents());
            grands.removeIf(grand -> grand.gender.equals(gender));
        } catch (Exception e) {
            return grands;
        }
        return grands;
    }

    private void setSpouse(Human human) {
        spouse.add(human);
    }

    

    @Override
    public int compareTo(Object o) {
        try {
            return Integer.compare(getId(), ((Human)o).getId());
        } catch (Exception e) {
            return -1;
        }
        
    }

}
