package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birth;
    private LocalDate death;
    private Human parentM;
    private Human parentF;
    private List<Human> children;


    public Human(String name,Gender gender, LocalDate birth, LocalDate death, Human parentM, Human parentF) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        this.parentM = parentM;
        this.parentF = parentF;
        children = new ArrayList<>();
    }
    public Human(String name,Gender gender, LocalDate birth) {
        this(name,gender,birth,null,null,null);
    }
    public Human(String name,Gender gender, LocalDate birth, Human parentM, Human parentF) {
        this(name,gender,birth,null,parentM,parentF);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    public LocalDate getDeath() {
        return death;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }
    public void setParentM(Human parentM){
        this.parentM = parentM;
    }

    public void setParentF(Human parentF){
        this.parentF = parentF;
    }

    public Human getParentF() {
        return parentF;
    }

    public Human getParentM() {
        return parentM;
    }

    public Gender getGender() {
        return gender;
    }

    public void addKid(Human kid){
        if (!children.contains(kid)){
            children.add(kid);
        }
    }

    public void addParent(Human parent){
        if (parent.getGender().equals(Gender.male)){
            setParentM(parent);
        }
        else if (parent.getGender().equals(Gender.female)){
            setParentF(parentF);
        }
    }

    public List<Human> getParent() {
        List<Human> parents = new ArrayList<>(2);
        if (parentM != null){
            parents.add(parentM);
        }
        if (parentF != null){
            parents.add(parentF);
        }
        return parents;
    }

    public int getAge(LocalDate birth, LocalDate death){
        if (death == null){
            death = LocalDate.now();
        }
        Period age = Period.between(birth,death);
        return age.getYears();
    }

    public String getParentMInfo(){
        String res;
        if (parentM != null){
            res = parentM.getName();
        }
        else {
            res = "none";
        }
        return res;
    }

    public String getParentFInfo(){
        String res;
        if (parentF != null){
            res = parentF.getName();
        }
        else {
            res = "none";
        }
        return res;
    }

    @Override
    public String toString(){
        return getData();
    }


    public String getData(){
        StringBuilder info = new StringBuilder();
        info.append("\n---------------");
        info.append("\nid: ");
        info.append(id);
        info.append("\nname: ");
        info.append(name);
        info.append("\ngender: ");
        info.append(getGender());
        info.append("\nage: ");
        info.append(getAge(birth,death));
        info.append("\nfather: ");
        info.append(getParentMInfo());
        info.append("\nmother: ");
        info.append(getParentFInfo());
        info.append("\nchildren: ");
        info.append(getChildrenInfo());
        return info.toString();
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        if (!children.isEmpty()){
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
        return name.compareTo(o.getName());
    }
}