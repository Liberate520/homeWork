package family_tree.human;

import family_tree.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class E implements Serializable, FamilyTreeItem {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<E> parents;
    private List<E> children;

    public E(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, E father, E mother){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
    public E(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }
    public E(String name, Gender gender, LocalDate birthDate, E father, E mother){
        this(name, gender, birthDate, null, father, mother);
    }
    public boolean addChild(E child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    };
     public void setId(long id){
         this.id = id;
     }
    public boolean addParent(E parent){
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
        }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public LocalDate getDeathDate(){
        return deathDate;
    }
    public E getFather(){
        for (E parent: parents){
            if(parent.getGender() == Gender.Male) return parent;
        }
        return null;
    }
    public E getMother(){
        for (E parent: parents){
            if(parent.getGender() == Gender.Female) return parent;
        }
        return null;
    }

    @Override
    public boolean addChild(Object human) {
        return false;
    }

    @Override
    public boolean addParent(Object human) {
        return false;
    }

    public Gender getGender() {
        return gender;
    }

    public List<E> getParents() {
        return parents;
    }

    public List<E> getChildren() {
        return children;
    }

    @Override
    public Object getSpouse() {
        return null;
    }

    @Override
    public void getSpouse(Object human) {

    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    @Override
    public String toString(){
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
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
        return sb.toString();
    }
    public String getMotherInfo(){
        String res = "мать: ";
        E mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        E father = getFather();
        if (father != null){
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
    public int getAge(){
        if (deathDate == null){
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
        boolean result;
        if (this == obj) {
            result = true;
        } else if (!(obj instanceof E)) {
            result = false;
        } else {
            E human = (E) obj;
            result = human.getName().equals(getName());
        }
        return result;
    }


}


