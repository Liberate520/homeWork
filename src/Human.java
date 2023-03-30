

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private int date;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();

    public Human(String name, Gender gender, int date, Human father, Human mother, List<Human> children) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.father = father;
        this.mother = mother;
        this.children=children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public Human setFather(Human father) {
        this.father = father;
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChildren(Human human) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(human);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("Имя: ").append(name).append(", ");
        if(gender == Gender.Male)
        {sb.append("пол: мужской").append(", ");}
        else
        {sb.append("пол: женский").append(", ");}
        sb.append("дата смерти: ").append(date).append(", ");
        if(father == null)
        {sb.append("отец неизвестен").append(", ");}
        else
        {sb.append("отец: ").append(father.getName()).append(", ");}
        if(mother == null)
        {sb.append("");}
        else
        {sb.append("мать: ").append(mother.getName()).append(", ");}      
        if (children == null)
        {sb.append("");}
        else
        {
            sb.append("дети: ");
            for (int i =0; i < children.size(); i++)
            {
                sb.append(children.get(i).getName()).append(", ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
