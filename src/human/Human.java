package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;



public class Human implements Serializable {

    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother, father;
    private List<Human> children;
    private Human partner;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate, null, mother, father);
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        return true;
    }

    public void setMother(Human mother){
        this.mother = mother;
    }

    public void setFather(Human father){
        this.father = father;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getPartner() {
        return partner;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if(father != null){
            list.add(father);
        }
        if(mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    public int getPeriod(LocalDate date1, LocalDate date2){
        Period diff = Period.between(date1, date2);
        return diff.getYears();
    }

    public void setPartner(Human partner) {
        this.partner = partner;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }


    public String getFatherInfo(){
        String fath;
        Human father = getFather();
        if(father!= null){
            fath = father.getName();
        } else {
            fath = "неизвестен";
        }
        return fath;
    }

    public String getMotherInfo(){
        String moth;
        Human mother = getMother();
        if(mother != null){
            moth = mother.getName();
        } else {
            moth = "неизвестна";
        }
        return moth;
    }

    public String getPartnerInfo(){
        String part;
        if(partner == null){
            part = "нет";
        } else {
            part = partner.getName();
        }
        return part;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getChildrenInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("дети: ");
        if(children.size() != 0){
            sb.append(children.get(0).getName());
            for(int i = 1; i < children.size(); i++){
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("отсутствуют");
        }
        return sb.toString();
    }

    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", отец: ");
        sb.append(getFatherInfo());
        sb.append(", мать: ");
        sb.append(getMotherInfo());
        sb.append(", партнер: ");
        sb.append(getPartnerInfo());
        sb.append(", дети: ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

}

