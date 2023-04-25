package human;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class   Human implements Serializable {
    private String name;
    private String surname;
    private Human mother;
    private Human father;
    private List<Human> children;
    private String bDay;
    SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
    public Human(String name, String surname, String bDay, Human mother, Human father, List<Human> children) {
        this.name = name;
        this.surname = surname;
        this.bDay = bDay;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }
    public Human(String name, String surname, String bDay, Human mother, Human father) {
        this(name,surname, bDay,mother,father,new ArrayList<>());
    }
    public Human(String name, String surname, String bDay) {
        this(name,surname,bDay,null,null,new ArrayList<>());
    }
    public Human() {

        this("","","01.01.0001");
    }
    public void setChildren(List<Human> children){
        this.children = children;
    }
    public void addChild(Human human){
        if (!children.contains(human)){
            this.children.add(human);
        }
    }
    public List<Human> getChildren(){
        return children;
   }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getbDay() {
        return bDay;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Человек: " + name + " " + surname + "; ");
        stringBuilder.append("Дата рождения: " + bDay + "; ");
        if(father != null) {
            stringBuilder.append("Отец: " + father.getName() + " " + father.getSurname() + "; ");
        }
        if(mother != null){
            stringBuilder.append("Мать: " + mother.getName() + " " + mother.getSurname() + "; ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString() ;
    }
}
