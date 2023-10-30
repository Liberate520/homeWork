package FamilyTree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{

    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;

    public Human(String name,Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public void addChild(Human child) {
        if(!children.contains(child)){
            children.add(child);
        }
    }

    public void addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)){
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
    }

    public Human (String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null,null,null);
    }

    public Human (String name, Gender gender, LocalDate birthDate,Human mother, Human father){
        this(name, gender, birthDate, null, mother, father);
    }
    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if(deathDate == null){
            return getPeriod(birthDate,LocalDate.now());
        } else {
            return getPeriod(birthDate,deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) { 
        this.birthDate = birthDate; 
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }
    public void setDeathDate(LocalDate deathDate) {
         this.deathDate = deathDate; 
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append ("id: "); 
        sb.append (id);
        sb.append (", имя: ");
        sb.append (name);
        sb.append (", пол: ");
        sb.append (getGender());
        sb.append (", возраст: ");
        sb.append (getAge());
        sb.append (",");
        sb.append (getSpouseInfo());
        sb.append (", ");
        sb.append (getMotherInfo());
        sb.append (", ");
        sb.append (getFatherInfo());
        sb.append (", ");
        sb.append (getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getName () ;
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "Мать: ";
        if (mother == null){
            res += "нет";
        } else {
            res += mother.getName () ;
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "Отец: ";
        if (father == null){
            res += "нет";
        } else {
            res += father.getName () ;
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append ("дети: ");
        if (children.size() != 0){
            res.append (children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append (", ");
                res.append(children.get(i).getName());     
            }
        } else {
            res. append ("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human)obj;
        return human.getId() == getId();
    }

}



