package human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import familyTree.Tree;

public class Human<T> implements Serializable, Comparable, IRelations<Human<T>> {
    public String name, surname;
    private static Integer HumansCount = 0;
    private Integer humanId;
    private Gender gender;
    private Integer birthYear;
    public Human<T> mother, father;
    private List<Human<T>> childs = new ArrayList<>();
    private List<Human<T>> spouse = new ArrayList<>();

    public Human(String name, String surname, Gender gender, Integer birthYear, Human<T> mother, Human<T> father) {
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
        Tree.humans.add(this);
    }

    public Human(String name, String surname, Gender gender, Integer birthYear) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthYear = birthYear;
        humanId = ++HumansCount;
        Tree.humans.add(this);
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
    
    public List<Human<T>> me() {
        List<Human<T>> me = new ArrayList<>();
        me.add(this);
        return me;
    }

    public List<Human<T>> parents() {
        List<Human<T>> parents = new ArrayList<>();
        if (mother != null && father != null) {
            parents.add(father);
            parents.add(mother);
        }
        return parents;
    }

    public List<Human<T>> childs() {
        return this.childs;
    }

    public List<Human<T>> spouse() {
        return spouse;
    }

    public int getId() {
        return this.humanId;
    }

    public List<Human<T>> brotherAndSisters() {
        List<Human<T>> brohersAndSisters = new ArrayList<>();
        try {
            brohersAndSisters = this.father.childs();
            brohersAndSisters.remove(this);
        } catch (Exception e) {
            return brohersAndSisters;
        }
        return brohersAndSisters;
    }

    public List<Human<T>> grandMothers() {
        return grand(Gender.Male);
    }

    public List<Human<T>> grandFathers() {
        return grand(Gender.Female);
    }

    public List<Human<T>> grandChildrens() {
        List<Human<T>> grandChildrens = new ArrayList<>();
        for (Human<T> human : this.childs) {
            grandChildrens.addAll(human.childs);
        }
        return grandChildrens;
    }

    public void addChild(Human<T> motherOrFather, Human<T> child) {
        if (child.father == null && child.mother == null && motherOrFather != child && this != child) {
            motherOrFather.childs.add(child);
            this.childs.add(child);
        }
    }

    public void addSpouse(Human<T> human) {
        if (spouse.isEmpty()) {
            setSpouse(human);
            human.setSpouse(this);
        } else {
            spouse.clear();
            setSpouse(human);
            human.setSpouse(this);
        }
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + Integer.toString(birthYear) + " " + gender;
    }

    private List<Human<T>> grand(Gender gender) {
        List<Human<T>> grands = new ArrayList<>();
        try {
            grands = this.father.parents();
            grands.addAll(this.mother.parents());
            grands.removeIf(grand -> grand.gender.equals(gender));
        } catch (Exception e) {
            return grands;
        }
        return grands;
    }

    private void setSpouse(Human<T> human) {
        spouse.add(human);
    }

    

    @Override
    public int compareTo(Object o) {
        try {
            return Integer.compare(getId(), ((Human<T>)o).getId());
        } catch (Exception e) {
            return -1;
        }
        
    }

}
