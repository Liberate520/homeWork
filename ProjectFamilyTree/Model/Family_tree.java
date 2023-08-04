package homeWork.ProjectFamilyTree.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family_tree<E extends Human> implements Serializable, Iterable<E> {
    private List<E> list = new ArrayList<>();
    /*public void addHuman(E human){list.add(human);}*/
    public Family_tree(){list = new ArrayList<>();}
    public void addHuman(String name, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender){
        Human human = new Human(name, localDateOfBirth, localDateofDeath, gender);
        list.add((E) human);
    }

    public void setParentsAndChilds(Human child, Human parent1, Human parent2) {
        if(child.getFather() == null && parent1.getGender().equals(Gender.Male)){
            child.setFather(parent1);
            child.setMother(parent2);
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        } else if (child.getFather() == null && parent2.getGender().equals(Gender.Male)) {
            child.setFather(parent2);
            child.setMother(parent1);
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        }
        else if((child.getFather().equals(parent1) || child.getFather().equals(parent2)) ||
                (child.getMother().equals(parent1) || child.getMother().equals(parent2))){
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        }
    }

    public void siblings(Human human1, Human human2){
        if((human1.getFather().equals(human2.getFather())) || human1.getMother().equals(human2.getMother())){
            human1.getSibling().add(human2);
            human2.getSibling().add(human1);
        }
    }

    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дерево:\n");
        for (E human: list){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<>(list);
    }
    public void sortByAge(){list.sort(new HumanComparatorByAge<E>());}
    public void sortByName(){list.sort(new HumanComparatorByName<E>());}
}
