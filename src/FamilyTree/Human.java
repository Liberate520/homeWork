package FamilyTree;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<Human> children;
    private List<Human> parents;
    
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }

        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null,null);
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public boolean addChild(Human child) {
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParent(Human parent) {
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }
    public void addFather(Human father) {
        this.father = father;
        father.addChild(this);
    }
    public void addMother(Human mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    private Gender getGender() {
        return gender;
    }
    public Human getSpouse() {
        return spouse;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }
    public List<Human> getChildren() { return children; }

    public void setMother(Human mother) {
        this.mother = mother;
        parents.add(mother);
    }
    public void setFather(Human father) {
        this.father = father;
        parents.add(father);
    }

    public void setSpouse(Human spouse) {
        setSpouse(spouse);
        spouse.setSpouse(this);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("пол: ");
        sb.append(getGender());
        sb.append(", ");
        sb.append("возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append("мать: ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append("отец: ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append("дети: ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getMotherInfo(){
        String res = "";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "";
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("");
        if (children.size() != 0){
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
    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate,LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human Person = (Human) obj;
        return Person.getName().equals(getName());
    }
}
    

