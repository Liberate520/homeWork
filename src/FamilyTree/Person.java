package FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static FamilyTree.Sex.Female;
import static FamilyTree.Sex.Male;

public class Person implements Serializable {
        private String name;
        private Sex sex;
        private LocalDate birthday;
        private LocalDate deathday;
        private List<Person>children;
        private List<Person> parents;
        private List<Person> spouses;

    public Person(String name, Sex sex, LocalDate birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        deathday = null;
        children = new ArrayList<>();
        parents = new ArrayList<>();
        spouses =new ArrayList<>();
    }
    public boolean addChild (Person child){
        if (!children.contains(child)){
            children.add (child);
            return  true;
        }
        return false;

    }
    public boolean addParent (Person parent){
        if (!parents.contains(parent)){
            parents.add (parent);
            return  true;
        }
        return false;

    }
    public boolean addSpouse (Person spouse){
        if (!spouses.contains(spouse)){
            spouses.add (spouse);
            return  true;
        }
        return false;

    }
    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDeathday() {
        return deathday;
    }
    public List<Person> getChildren() {
        return children;
    }

    public Person getFather() {
        for (Person father : parents) {
            if (father.getSex() == Male) {

                return father;
            }
        }
    return  null;
    }
    public Person getMother() {
        for (Person mother : parents) {
            if (mother.getSex() == Female) {

                return mother;
            }
        }
        return  null;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", deathday=" + deathday +
                '}';
    }
    public String getChildrenInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Дети у ");
        sb.append(this.getName());
        sb.append(" : ");
        if (children.size()!=0 ){
            sb.append(children.get(0).getName());

                for (int i = 1; i < children.size(); i++) {
                    sb.append(", ");
                    sb.append(children.get(i).getName());

            }
            return sb.toString();
        }
        sb.append ("не известны");
    return sb.toString();
    }
    public String getParentsnfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Родители: ");
        if (parents.size()!=0 ){
            sb.append(parents.get(0).getName());
            for (int i=1; i<= parents.size(); i++ ){
                sb.append(", ");
                sb.append(parents.get(i).getName());
            }
            sb.append ("не известны");
        }
        return sb.toString();
    }
    public String getSpouseInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Дети: ");
        if (spouses.size()!=0 ){
            sb.append(spouses.get(0).getName());
            for (int i=1; i<= spouses.size(); i++ ){
                sb.append(", ");
                sb.append(spouses.get(i).getName());
            }
            sb.append ("не известны");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName());
    }


}
