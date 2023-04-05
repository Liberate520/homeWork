import javax.lang.model.element.Name;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private String surname;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Date bDay;

    SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");

    public Human(String name, String surname, String bDay, Human mother, Human father, List<Human> children) throws Exception{
        this.name = name;
        this.surname = surname;
        this.bDay = formatDate.parse(bDay);
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Human(String name, String surname, String bDay, Human mother, Human father) throws Exception{
        this(name,surname, bDay,mother,father,new ArrayList<>());
    }

    public Human(String name, String surname, String bDay) throws Exception{
        this(name,surname,bDay,null,null,new ArrayList<>());
    }

    public Human() throws Exception{

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

    public Date getbDay() {
        return bDay;
    }

    @Override
    public String toString() {
        return "Human{"  + name + " " + surname  +'}';
    }
}
