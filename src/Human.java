import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;


public class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Human mother;
    private Human father;
    private List<Human> children;
    private String sex;
    private Human wifeOrHusband;
    private String birthDay;
    private int birth_date;
    private int birth_month;
    private int birth_year;
    }
    public Human(String name, String surname, String patronymic, Human mother, Human father, List<Human> children){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Human(String name, String surname, String patronymic, Human mother, Human father){
        this(name,surname,patronymic,mother,father,new ArrayList<>());
    }

    public Human(String name, String surname, String patronymic){
        this(name,surname,patronymic,null,null,new ArrayList<>());
    }

    public Human(){
        this("","");
    }


    public void addChildren(Human human){
                this.children.add(human);
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

