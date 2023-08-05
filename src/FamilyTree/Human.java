package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human implements Serializable {
    private Date birthday;
    private Gender gender;
    private String name;
    private Human father;
    private Human mother;
    private List<Human> children;
    private int id;

    public Human(String name, Date birthday, Gender gender, Human father, Human mother, List<Human> children) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Human(String name, Date birthday, Gender gender) {
        this(name, birthday, gender, null, null, new ArrayList<>());
    }

    @Override
    public String toString() {
        return name;
    }

    public String getBirthDay() {
        if (birthday != null) {
            return String.format("%s:%s:%s", this.birthday.getYear(), this.birthday.getMonth(), this.birthday.getDay());
        } else {
            return null;
        }
    }

    public Human getFather() {
        return this.father;
    }

    public Human getMother() {
        return this.mother;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public String getFullInfo() {
        String father_name = "No info";
        String mother_name = "No info";
        String children_names = "No info";
        if (this.father != null) {
            father_name = this.father.toString();
        }
        if (this.mother != null) {
            mother_name = this.mother.toString();
        }
        if (this.children != null) {
            children_names = this.children.toString();
//            for (int i = 1; i <= children.size(); i++){
//                children_names
//            }
        }
        String info = String.format("Person:%s. Birthday:%s. Gender:%s. Father:%s, Mother:%s, Childrens:%s\n"
                , this.name, this.birthday, this.gender, father_name, mother_name, children_names);
        return info;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public Gender getGender(){
        return this.gender;
    }
}
