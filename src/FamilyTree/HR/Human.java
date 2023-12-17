package FamilyTree.HR;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {  //, CommonParam<Human>{   Serializable можно тогда убрать
    private int id;
    private String name;
    private Gender gender;
    private String place_of_residence;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human spouse;
    private Human mother;
    private Human father;
    private  List<Human> children;

    public Human(String name, Gender gender, String place_of_residence,
                 LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.place_of_residence = place_of_residence;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, String place_of_residence, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, place_of_residence, birthDate, null, father, mother);
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, null, birthDate, null, mother, father);
    }
    public Human(String name, Gender gender, String place_of_residence, LocalDate deathDate) {
        this(name, gender,  place_of_residence,null, deathDate, null,null);
    }
    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, null, birthDate, null, null, null);
    }

    public void setId(int id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender(){
        return gender;
    }
    public void setPlace_of_residence(String place_of_residence) {
        this.place_of_residence = place_of_residence;
    }
    public String getPlace_of_residence(){
        return place_of_residence;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public LocalDate getDeathDate(){
        return deathDate;
    }
    public void setMother(Human mother) { this.mother = mother;   }
    public Human getMother() {
        return mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getFather() {
        return father;
    }
    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }
    public Human getSpouse(){
        return spouse;
    }
    public List<Human> getChildren(){
        return children;
    }

    public boolean addChild(Human child){
        if(!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
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
            return getPeriod(birthDate, LocalDate.now());
        }
        else{
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public LocalDate getLived(){
        if (birthDate == null && deathDate != null) {
            return deathDate;
        }
        return null;
    }

    public String getSpouseInfo(){
        String result = "супруг(а): ";
        if (spouse == null) {
            result += "нет";
        }
        else{
            result+= spouse.getName();
        }
        return result;
    }
    public String getMotherInfo(){
        String result = "мать: ";
        Human mother = getMother();
        if (mother != null){
            result += mother.getName();
        }
        else {
            result += "неизвестна";
        }
        return result;
    }


    public String getFatherInfo(){
        String result = "отец: ";
        Human father = getFather();
        if (father != null){
            result += father.getName();
        }
        else {
            result += "неизвестен";
        }
        return result;
    }
    public String getChildrenInfo(){
        StringBuilder chldrn = new StringBuilder();
        chldrn.append("дети: ");
        if (!this.children.isEmpty()) {
            chldrn.append(this.children.get(0).getName());
            for (int i = 1; i < this.children.size(); i++) {
                chldrn.append(", ");
                chldrn.append(this.children.get(i).getName());
            }
        }
        else {
            chldrn.append("отсутствуют");
        }
        return chldrn.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder PersData = new StringBuilder();
        PersData.append("id: ");
        PersData.append(id);
        PersData.append(", имя: ");
        PersData.append(name);
        PersData.append(", пол: ");
        PersData.append(getGender());
        PersData.append(", ");
        PersData.append(", проживает(-л) в ");
        PersData.append(getPlace_of_residence());
        PersData.append(", ");
        PersData.append(getLived());
        PersData.append(", возраст: ");
        PersData.append(getAge());
        PersData.append(", супруг(а): ");
        PersData.append(getSpouseInfo());
        PersData.append(", ");
        PersData.append(getMotherInfo());
        PersData.append(", ");
        PersData.append(getFatherInfo());
        PersData.append(", ");
        PersData.append(getChildrenInfo());
        return PersData.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
