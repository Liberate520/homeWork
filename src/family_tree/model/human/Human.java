package family_tree.model.human;


import family_tree.model.tree.Entity;
import family_tree.model.tree.SentientEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;



public class Human implements Serializable, Comparable<Human>, SentientEntity<Human> {
    private int id;
    private String name;
    private LocalDate dateOfBirth, dateOfDeath;
    private boolean alive;
    private Gender gender;
    private HashMap<Human,Parent_Type> parents;
    private boolean hasBioMother;
    private boolean hasBioFather;
    private Human spouse;
    private boolean married;
    private HashMap<Human, Child_type> children;

    public Human(String name, LocalDate dateOfBirth,
                 LocalDate dateOfDeath, Gender gender) {
        id = -1;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.parents = new HashMap<>();
        this.children = new HashMap<>();
        this.alive = true;
        this.hasBioFather = false;
        this.hasBioMother = false;
        this.married = false;
    }
    public Human(String name, LocalDate dateOfBirth, Gender gender) {
        this(name, dateOfBirth, null, gender);
    }

    @Override
    public HashMap<Human, Parent_Type> getParents() {
        return parents;
    }

    @Override
    public HashMap<Human, Child_type> getChildren() {
        return children;
    }

    @Override
    public int getId(){
        return this.id;
    }
    @Override
    public void setId(int id){
        this.id = id;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Gender getGender(){
        return this.gender;
    }


    @Override
    public Human getSpouse() {
        return spouse;
    }

    @Override
    public boolean isMarried(){
        return this.married;
    }

    @Override
    public boolean isHasBioFather() {
        return hasBioFather;
    }

    @Override
    public boolean isHasBioMother() {
        return hasBioMother;
    }
    @Override
    public void setHasBioFather() {
        hasBioFather = true;
    }

    @Override
    public void setHasBioMother() {
        hasBioMother = true;
    }

    @Override
    public void setSpouse(Human spouse){
        this.spouse = spouse;
        this.married = true;
    }

    @Override
    public void removeSpouse(){
        this.spouse = null;
        this.married = false;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
        this.alive = false;
    }

    @Override
    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    @Override
    public int getAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period difference;
        int age = 0;
        if (!(this.dateOfDeath == null))
        {
            difference = Period.between(dateOfBirth, dateOfDeath);
        }
        else{
            difference = Period.between(dateOfBirth, LocalDate.now());
        }
        age = difference.getYears();
        return age;
    }

    @Override
    public String toString() {
        return infoFormat();
    }

    public String infoFormat(){
        StringBuilder sb = new StringBuilder();
        sb.append(nameInfo());
        sb.append(ageInfo());
        sb.append(genderInfo());
        sb.append(parentsInfo());
        sb.append(marriageInfo());
        sb.append(childrenInfo());
        return sb.toString();
    }

    public String nameInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ФИО: ").append(this.name).append("\n");
        return sb.toString();
    }

    public String ageInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Дата рождения: ").append(this.dateOfBirth).append("\n");
        if(this.alive){
            sb.append("Возраст: ").append(getAge(this.dateOfBirth, null)).append(" лет").append("\n");
        }
        else{
            sb.append("Дата смерти: ").append(this.dateOfDeath).append("\n");
        }
        return sb.toString();
    }

    public String genderInfo(){
        StringBuilder sb = new StringBuilder();
        if(this.gender.equals(Gender.male)){
            sb.append("Пол: мужской").append("\n");
        }
        else{
            sb.append("Пол: женский").append("\n");
        }
        return sb.toString();
    }

    public String parentsInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human parent : this.parents.keySet()) {
            if(this.parents.get(parent).equals(Parent_Type.Biological_Mother)) sb.append("Родная мать: ").append(parent.getName()).append("\n");
            else if(this.parents.get(parent).equals(Parent_Type.Biological_Father)) sb.append("Родной отец: ").append(parent.getName()).append("\n");
            else if(this.parents.get(parent).equals(Parent_Type.Foster_Father)) sb.append("Приемный отец: ").append(parent.getName()).append("\n");
            else if(this.parents.get(parent).equals(Parent_Type.Foster_Mother)) sb.append("Приемная мать: ").append(parent.getName()).append("\n");
        }
        return sb.toString();
    }

    public String marriageInfo(){
        StringBuilder sb = new StringBuilder();
        if (this.married){
            if(this.spouse.gender.equals(Gender.male)) sb.append("Муж: ").append(spouse.getName()).append("\n");
            else sb.append("Жена: ").append(spouse.getName()).append("\n");
        }
        else {
            if(this.gender.equals(Gender.male)) sb.append("Не женат").append("\n");
            else sb.append("Не замужем").append("\n");
        }
        return sb.toString();
    }

    public String childrenInfo(){
        StringBuilder sb = new StringBuilder();
        if (this.children.isEmpty()){
            sb.append("Детей нет").append("\n");
        }
        else {
            for(Human child : this.children.keySet()){
                if(this.children.get(child).equals(Child_type.Biological_Son)) sb.append("Родной сын: ").append(child.getName()).append("\n");
                else if(this.children.get(child).equals(Child_type.Biological_Daughter)) sb.append("Родная дочь: ").append(child.getName()).append("\n");
                else if(this.children.get(child).equals(Child_type.Foster_Son)) sb.append("Приемный сын: ").append(child.getName()).append("\n");
                else if(this.children.get(child).equals(Child_type.Foster_Daughter)) sb.append("Приемная дочь: ").append(child.getName()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id;
    }

    @Override
    public int compareTo(Human o) {
        return 0;
    }
}
