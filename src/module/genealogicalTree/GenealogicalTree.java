package module.genealogicalTree;

import module.Service.TreeNode;
import module.human.ComparatorByAge;
import module.human.ComparatorByName;
import module.human.Gender;
import module.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenealogicalTree<T extends TreeNode> implements Serializable, Iterable<T> {

    private List<T> humanList;
    private int idPerson;

    public GenealogicalTree() {
        humanList = new ArrayList<>();
    }

    public GenealogicalTree(List<T> humanList) {
        this.humanList = humanList;
    }



    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        for (T human: humanList
             ) {
            String part = human.getInfo();
            sb.append(part);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addHuman(T human){
        if(!humanList.contains(human)) {
            humanList.add(human);
        }
    }

    public void addHuman(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children){
        T human = (T) new Human(idPerson++, name, lastName, gender, birthDate, deathDate, mother, father, spouse, children);
        humanList.add(human);
    }

    public void showAllHumans(){
        for (T human: this.humanList
        ) {
            System.out.println(human);
        }
    }

    public List<T> getHumanByLastName(String lastName) {
        List<T> result = new ArrayList<>();
        for (T human:humanList
        ) {
            String lastNameHuman = human.getLastName();
            if(lastNameHuman.equalsIgnoreCase(lastName)) result.add(human);
        }
        return result;
    }


    public List<T> getHumanByName(String name) {
        List<T> result = new ArrayList<>();
        for (T human:humanList
        ) {
            String nameHuman = human.getName();
            if(nameHuman.equalsIgnoreCase(name)) result.add(human);
        }
        return result;
    }

    private String getName(T human) {
        return getName(human);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T human: humanList
        ) {
            sb.append(human.toString());
            sb.append("--------------------");
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

    public void sortByAge(){
        humanList.sort(new ComparatorByAge<>());
    }

    public void sortByName(){
        humanList.sort(new ComparatorByName<>());
    }
}

