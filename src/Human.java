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
    public String toString(Human human) {        
        return "Имя: "+human.name+"; " +"Пол: "+human.gender+"; "+"Отец: "+this.father+"; " +"Мать: "+human.mother+"; " +"Дети: "+ human.children;
    }

}
