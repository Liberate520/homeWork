import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Human(String name, Gender gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public void addChild(Human human) {
        children.add(0, human);
    }

    public String getInfo() {
        return String.format("Имя: %s; Пол: %s; Отец: %s; Мать: %s.", name, gender, father, mother);
    }

}
