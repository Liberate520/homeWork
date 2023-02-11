import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public void AddChild(Human human) {
        children.add(0, human);


    }

    @Override
    public String toString() {        
        return "Имя: "+this.name+"; " +"Пол: "+this.gender+"; "+"Отец: "+this.father+"; " +"Мать: "+this.mother+"; " +"Дети: "+ this.children;
    }

}
