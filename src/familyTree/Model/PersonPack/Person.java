package Model.PersonPack;

import Model.TreePack.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Person implements Serializable, TreeItem<Person> {
    private String name;
    private LocalDate birthDate;
    private Person father, mother;
    private ArrayList<Person> children  = new ArrayList<Person>();

    private Gender gender;

    public Person(String name, Gender gender, String date) {
        this.name = name;
        this.gender = gender;
        this.birthDate = LocalDate.parse(date);
    }
    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    public void setFather(Person father){
        this.father = father;
    }

    public void setMother(Person mother){
        this.mother = mother;
    }

    public void addParent(Person parent){
        if (parent.gender.equals(Gender.male)){
            this.setFather(parent);
            if (! parent.getChildren().contains(this)){
                parent.addChild(this);
            }
        }else{
            this.setMother(parent);
            if (! parent.getChildren().contains(this)){
                parent.addChild(this);
            }
        }
    }
    public void addChild(Person child){
        this.children.add(child);
    }

    public ArrayList<Person> getChildren(){
        return children;
    }

    @Override
    public String toString() {
        String tmp = "name: " + name + "\n"+
                "gender: " + gender + "\n"+
                "date of birth: " + birthDate + "\n" + "parents: ";

        if (this.father != null){
            tmp += father.name + ", ";
        }else{
            tmp += "--" + ", ";
        }

        if (this.mother != null){
            tmp += mother.name + "\n";
        }else{
            tmp += "--" + "\n";
        }

        tmp += "children: ";

        for (Person item : children) {
            tmp += item.name + " ";
        }
        tmp += "\n";
        return tmp;

    }
}
