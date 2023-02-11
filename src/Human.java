import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;


    public Human(String name,Gender gender,Human father,Human mother){
        this.name=name;
        this.gender=gender;
        this.father=father;
        this.mother=mother;

    }

    public void AddChild(Human human) {
        children.add(0, human);
    }
    

public String toString(Human human2) {        
        return "Имя: "+name+"; " +"Пол: "+gender+"; "+"Отец: "+human2.father+"; " +"Мать: "+human2.mother+"; " +"Дети: "+ children;
    }

}
