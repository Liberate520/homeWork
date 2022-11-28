import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// может дерево сделать интерфейсом?

public class Tree {
    // ¬ дереве храним всех добавл€емых людей
    List<Human> humanList;
    List<Animal> animalList;
//    List<Human<Link>> links;


    //когда создаЄм новое дерево
    public Tree() {
        this.humanList = new ArrayList<>();
    }


    public List<Human> getHumanList() {
        return humanList;
    }
    public Human getHumanList(int i) {
        return humanList.get(i);
    }

    // добавл€ем человека в дерево
    public void addTree(FamiliesI person) {
        if(person instanceof Human)
            this.humanList.add((Human) person);
        if(person instanceof Animal)
            this.animalList.add((Animal) person);

    }

}
