package family_tree.human;

import family_tree.infrastucture.de_serelization.My_Serialization;
import family_tree.tree.tree_service.HumanIterator;

//import java.io.Serial;
//import java.io.Serializable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Human implements My_Serialization, Iterable<Human>, Comparable<Human>{
    static final long serialVersionUID = My_Serialization.serialVersionUID;

    private long id;
    private  String surname;
    private String first_name;
    private String patronymic;
    private LocalDate day_birth;
    private LocalDate day_death;
    private Gender gender;

    private List<Human> parents;
    private Human spouse;
    private List<Human> children;

    public Human (String surname, String first_name, String patronymic, Gender gender, LocalDate day_birth, LocalDate day_death,
                  Human father, Human mother) {
        id = -1;
        this.surname = surname;
        this.first_name = first_name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.day_birth = day_birth;
        this.day_death = day_death;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
    public Human(String surname, String first_name, String patronymic, Gender gender, LocalDate day_birth, Human father, Human mother){
        this(surname, first_name, patronymic, gender, day_birth, null, father, mother);
    }

    public Human(String surname, String first_name, String patronymic, Gender gender, LocalDate day_birth){
        this(surname, first_name, patronymic, gender, day_birth, null, null);
    }

    public Human(String surname, String first_name, String patronymic, Gender gender){
        this(surname, first_name, patronymic, gender, null, null, null);
    }

    public Human(Gender gender) {
        this.gender = gender;
    }

    public boolean addChild (Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent (Human parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return  true;
        }
        return false;
    }


    public Human getMother() {
        if (parents != null) {
            for (Human mother : parents) {
                if (mother.getGender() == Gender.Female) {
                    return mother;
                }
            }
        }
        return null;
    }

    public Human getFather() {
        for (Human father : parents) {
            if (father.getGender() == Gender.Mail) {
                return father;
            }
        }
        return null;
    }

    public int getAge(){
        return day_death == null ? getPeriod(day_birth, LocalDate.now()) : getPeriod(day_birth, day_death);
    }

    private int getPeriod(LocalDate day_birth, LocalDate day_death){
        Period year_diff = Period.between(day_birth, day_death);
        return year_diff.getYears();
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDay_birth(LocalDate day_birth) {
        this.day_birth = day_birth;
    }

    public void setDay_death(LocalDate day_death) {
        this.day_death = day_death;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDay_birth() {
        return day_birth;
    }

    public LocalDate getDay_death() {
        return day_death;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getSpouse() {
        return spouse;
    }
    public List<Human> getChildren() {
        return children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", ФИО: ");
        sb.append(getFullName());
        sb.append(", Пол: ");
        sb.append(getGender());
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getParentsInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getFullName(){
        StringBuilder sb = new StringBuilder();
        sb.append(surname);
        sb.append(" ");
        sb.append(first_name);
        sb.append(" ");
        sb.append(patronymic);
        return sb.toString();
    }

    public String getFullNameToCompare(){
        StringBuilder sb = new StringBuilder();
        sb.append(surname);
        sb.append(" ");
        sb.append(patronymic);
        sb.append(" ");
        sb.append(first_name);
        return sb.toString();
    }

    public String getSpouseInfo(){
        String string = "Cупруг(а): ";
        if (spouse == null) {
            string += "нет";
        } else {
            string += spouse.getFullName();
        }
        return string;
    }

    public String getParentsInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Родители: ");
        if (parents.size() != 0){
            sb.append(parents.get(0).getFullName());
            for (int i = 1; i < parents.size(); i++){
                sb.append(", ");
                sb.append(parents.get(i).getFullName());
            }
        } else {
            sb.append("неизвестны");
        }
        return sb.toString();
    }

    public String getChildrenInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Дети: ");
        if (children.size() != 0){
            sb.append(children.get(0).getFullName());
            for (int i = 1; i < children.size(); i++){
                sb.append(", ");
                sb.append(children.get(i).getFullName());
            }
        } else {
            sb.append("отсутствуют");
        }
        return sb.toString();
    }

    public  boolean equals(Object obj){
        if (this == obj){
            return  true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(parents);
    }

    @Override
    public void forEach(Consumer<? super Human> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public int compareTo(Human o) {

        return getFullNameToCompare().compareTo(o.getFullNameToCompare());
    }


    @Override
    public boolean save(Serializable serializable, String filePath) {
        return false;
    }

    @Override
    public Object load(String filePath) {
        return null;
    }
}




