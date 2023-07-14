package homeWork.FamalyTree.model.Human;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import homeWork.FamalyTree.model.FamalysTree.ItemTree;

public class Human implements Comparable<Human>, ItemTree<Human> {
    private long id;
    private String name;
    private String last_name;
    private LocalDate DOB;
    private LocalDate DOD ;
    private Gender gender;
    private List<Human> children;
    private List<Human> parents;

    public Human(String name, String last_name, LocalDate DOB, LocalDate DOD, Gender gender, Human father, Human mother){
        id = -1;
        this.name = name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.DOD = DOD;
        this.gender = gender;
        parents = new ArrayList<>();
        if (father != null){parents.add(father);}
        if (mother != null){parents.add(mother);}
        children = new ArrayList<>();
    }
     public Human(String name, String last_name, LocalDate DOB, Gender gender){
        this(name, last_name, DOB, null, gender, null, null);
    }

     public Human(String name, String last_name, LocalDate DOB, Gender gender, Human father, Human mother){
        this(name, last_name, DOB, null, gender, father, mother);
    }

     public Human(String name, String last_name, LocalDate DOB, LocalDate DOD, Gender gender){
        this(name, last_name, DOB, DOD, gender, null, null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return last_name;
    }

    public LocalDate getDOB(){
        return DOB;
    }

    public LocalDate getDOD(){
        return DOD;
    }

    public Gender getGender(){
        return gender;
    }

    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male)
            return parent;
        }
        return null;
    }

    public Human getMother(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female)
            return parent;
        }
        return null;
    }

    public boolean addChild (Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParents (Human parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public List<Human> getParents(){
        return parents;
    }
    
    public List<Human> getChildren(){
         return children;
    }

    public int getAge(){
        if (DOD == null){
            return getLifeAge(DOB, LocalDate.now());
        }
        else{
            return getLifeAge(DOB,DOD);
        }
        
    }

    public int getLifeAge(LocalDate DOB, LocalDate DOD){
        Period diff = Period.between(DOB, DOD);
        return diff.getYears();
    }

    @Override
    public String toString() {        
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", last name: ");
        sb.append(last_name);
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", father: ");
        sb.append(getFatherInfo());
        sb.append(", mother: ");
        sb.append(getMotherInfo());
        sb.append(", children: ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    
    public String getFatherInfo() {
        String dad;
        Human father = getFather();
        if (father != null){dad = father.getName();}
        else {dad = "none";}
        return dad;
    }

    public String getMotherInfo() {
        String mam;
        Human mother = getMother();
        if (mother != null){mam = mother.getName();}
        else {mam = "none";}
        return mam;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();        
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }        
        }
        else{
            res.append("none");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
    
    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    @Override
    public LocalDate DOD() {
        return DOD;
    }

    @Override
    public LocalDate DOB() {
        return DOB;
    }

    @Override
    public long setId() {
        return setId();
    }

}


