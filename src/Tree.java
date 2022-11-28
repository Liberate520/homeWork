import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// может дерево сделать интерфейсом?

abstract class Tree implements FamiliesI{
    // В дереве храним всех добавляемых людей
    static List<Human> humanList = new ArrayList<>();
    static List<Animal> animalList = new ArrayList<>();
//    List<Human<Link>> links;


    //когда создаём новое дерево
    public Tree() {
    }


    public static List<Human> getHumanList() {
        return humanList;
    }
    public static Human getHumanList(int i) {
        return humanList.get(i);
    }


    // добавляем человека в дерево
    @Override
    public void addTree(FamiliesI person) {
        if(person instanceof Human)
            this.humanList.add((Human) person);
        if(person instanceof Animal)
            this.animalList.add((Animal) person);
    }
    public void addTree() {
        this.addTree(this);
    }

    @Override
    public void printTree() {

        //ищем начало дерева
        int max = 0;
        for (FamiliesI person : Tree.getHumanList()) {
            for (Link link : person.getLink()){

            }
        }

    }



}
