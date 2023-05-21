package model.Elements;

import java.util.ArrayList;
import java.util.List;

public class Human extends TreeElement  {
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human>children;

    public Human(String name, int birthday, int deathDay) {
        super(name, birthday, deathDay);
        this.children = new ArrayList<>();
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void addChildren(Human child) {
        children.add(child);
    }

    public List<String> getChildrensName() {
        List<String> result = new ArrayList<>();
        for (Human item:
             children) {
            result.add(item.name);
        }
        return result;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ").append(name).append(" ").append(birthday).append("-").append(deathDay).append("\n");
        if(father != null){
            sb.append("отец: ").append(father.getName()).append("\n");
        }
        if(mother != null){
           sb.append("мать: ").append(mother.getName()).append("\n");
        }
        if(spouse != null){
            sb.append("супруг(а): ").append(spouse.getName()).append("\n");
        }
        sb.append("дети: ").append(getChildrensName()).append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(TreeElement o) {
        return -1 * (birthday - o.birthday);
    }

}
