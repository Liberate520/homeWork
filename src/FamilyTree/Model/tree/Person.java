package FamilyTree.Model.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Being {
    private String name;
        private Integer id;
        private Enum sex;
        private LocalDate birthday;
        private LocalDate deathday;
        private List<Person>children;
        private List<Person> parents;
        private List<Person> spouses;

    public Person(String name, Enum sex, LocalDate birthday) {

        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        id = 0;
        deathday = null;
        children = new ArrayList<>();
        parents = new ArrayList<>();
        spouses =new ArrayList<>();

    }

    public Person() {
    }

    public boolean addChild(Being child){
        if (!children.contains((Person) (child))){
            children.add ((Person)(child));
            return  true;
        }
        return false;

    }

    public boolean addParent (Being parent){
        if (!parents.contains((Person) (parent))){
            parents.add ((Person) (parent));
            return  true;
        }
        return false;

    }

    public boolean addSpouse (Being spouse){
        if (!spouses.contains((Person) (spouse))){
            spouses.add ((Person) (spouse));
            return  true;
        }
        return false;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Enum getSex() {
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
            if (father.getSex() == Sex.Male) {

                return father;
            }
        }
    return  null;
    }
    public Person getMother() {
        for (Person mother : parents) {
            if (mother.getSex() == Sex.Female) {

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
        return "id =" +id+ "{" +
                ", name='" + name + '\'' +
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
        sb.append("Родители у: ");
        sb.append(this.getName());
        sb.append(" : ");
        if (parents.size()!=0 ) {
            sb.append(parents.get(0).getName());
            for (int i = 1; i < parents.size(); i++) {
                sb.append(", ");
                sb.append(parents.get(i).getName());
            }
            return sb.toString();
        }
            sb.append ("не известны");

        return sb.toString();
    }
    public String getSpouseInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Супруги у: ");
        sb.append(this.getName());
        sb.append(" : ");
        if (spouses.size()!=0 ) {
            sb.append(spouses.get(0).getName());
            for (int i = 1; i < spouses.size(); i++) {
                sb.append(", ");
                sb.append(spouses.get(i).getName());
            }
            return sb.toString();
        }
            sb.append ("не известны");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName());
    }

    public String showAllPersonInfo() {
        return this.toString()+ "\n"+
                this.getChildrenInfo()+"\n"+
                this.getParentsnfo()+ "\n"+
                this.getSpouseInfo();

    }


}
