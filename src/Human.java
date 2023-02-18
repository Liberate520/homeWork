import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children=new ArrayList<>();
    }

    public Human(String name, Gender gender) {
        this(name, gender, null,null);
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public String getName() {        
        return name;
    }

    public Gender getGender() {        
        return gender;
    }
   
    public Human getFather() {        
        return father;
    }
    public Human getMother() {        
        return mother;
    }
    
    public String getInfo() {
        return String.format("Имя: %s; Пол: %s; Отец: %s; Мать: %s.", name, gender, getFatherInfo(), getMotherInfo());
    }

       public String getMotherInfo() {
        String rez="";
        if (mother!=null){
            rez+=mother.name;
        }
        else{
            rez="неизвестна";
        }
        return rez;
    }

    public String getFatherInfo() {
        String rez="";
        if (father!=null){
            rez+=father.name;
        }
        else{
            rez="неизвестен";
        }
        return rez;
    }





}
