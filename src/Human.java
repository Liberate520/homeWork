package Project_MyFamilyTree;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>{
    public String name;
    private LocalDate birthday;
    private Gender gender;
    public Human father;
    public Human mother;
    public List<Human> childrens;
    private int glodal_id;
    private static int id;
    



    public void setName (String name){
        this.name = name;
    }
    public String getName (){
        return name;
    }
    public void setBirthday (LocalDate birthday){
        this.birthday = birthday;
    } 
    public LocalDate getBirthday (){
        return birthday;
    }
    public void setGender (Gender gender){
        this.gender = gender;
    }
    public Gender getGender (){
        return gender;
    }
    public void setFather (Human father){
        this.father = father;
    }
    public Human getFather (){
        return father;
    }
    public void setMother (Human mother){
        this.mother = mother;
    }
    public Human getMother (){
        return mother;
    }
    public void Childrens (){
        childrens = new ArrayList<>();
    }
    public void addChildren (Human human){
        childrens.add (human);
    }
    public String getChildrens(List <Human> childrens){
        StringBuilder stringBuilder = new StringBuilder();
        for(Human human: childrens){
            stringBuilder.append(human.getName());
            stringBuilder.append(human.getBirthday());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    

    public Human(String name, LocalDate birthday, Gender gender, Human father, Human mother, List<Human> childrens){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        //this.childrens = childrens;
        childrens = new ArrayList<>();
        id = glodal_id++;    
    }
    
    public Human(String name, LocalDate birthday, Gender gender){
        this(name, birthday, gender, null, null,null);
    }

    public Human(){
    }
    // public Human(String name, String birthday, Gender gender, Human father, Human mother){
    //     this.name = name;
    //     this.birthday = birthday;
    //     this.gender = gender;
    //     this.father = father;
    //     this.mother = mother;
    // }

    // public Human(String name, String birthday, Gender gender, List<Human> childrens){
    //     this.name = name;
    //     this.birthday = birthday;
    //     this.gender = gender;
    //     this.childrens = childrens;
    // }

    

    @Override
    public String toString() {
        return "id:" + id + '\n'
        + "Имя:" + name + '\n'
        + "Дата рождения: " + birthday + '\n'
        + "Пол: " + gender + '\n'
        + "Отец: " + father.getName() + ", " + father.getBirthday() + '\n'
        + "Mать: " + mother.getMother() + ", " + mother.getBirthday() + '\n'
        + "Дети: " + getChildrens(childrens);
    }
    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    @Override
    public int compareTo(Human o) {
        return birthday.compareTo(o.birthday);
    }
}
