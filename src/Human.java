import java.io.LineNumberInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable  {

    public Human mother;
    public Human father;
    private String family;
    private String name;
    private Gender gender;
    private String birthdate;
    private List<Human> сhildrenList;


    public Human(Human father, Human mother, String family, String name, Gender gender, String birthdate) {
        this.mother = mother;
        this.father = father;
        this.family = family;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.сhildrenList =new ArrayList<>();
    }

    public Human(String family, String name,Gender gender,String birthdate) {
        this (null,null , family, name, gender, birthdate);
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

 //  public void setName(String name) {
//        this.name = name;
//    }

    public Gender getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

//    public void setBirthdate(String birthdate) {
//        this.birthdate = birthdate;
//    }

//    public void newChildrenList() {
//        this.сhildrenList = new ArrayList<>();
//    }


    public void addChildrenList(Human human) {

        this.сhildrenList.add(human);
    }

    public List<Human> getСhildrenList() {
        return сhildrenList;
    }



    private String getInfo(){
        return String.format("\n\nФамилия: %s;\nИмя: %s;\nПол: %s;\nДата рождения: %s;", family, name, gender,birthdate);
    }



    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(family, human.family) && Objects.equals(name, human.name) && Objects.equals(birthdate, human.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, family, name, gender, birthdate, сhildrenList);
    }

}
