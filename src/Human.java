import javax.lang.model.element.Name;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private String surname;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, String surname, Human mother, Human father, List<Human> children){
        this.name = name;
        this.surname = surname;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Human(String name, String surname, Human mother, Human father){
        this(name,surname,mother,father,new ArrayList<>());
    }

    public Human(String name, String surname){
        this(name,surname,null,null,new ArrayList<>());
    }

    public Human(){
        this("","");
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

    @Override
    public String toString() {
        return "Human{"  + name + " " + surname  +'}';
    }
}
