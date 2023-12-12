package family;

import family.HumanIterator;
import human.Human;
import human.HumanComparatorByBirn;
import human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Tree implements Serializable, Iterable<Human> {
    private List<Human> treeMan;

    //Конструктор
    public Tree() {
        treeMan=new ArrayList<Human>();
    }


    //Методы
    public void addPeople(List <Human> newpeople){
        for (Human human: newpeople ){
            treeMan.add(human);
        }
    }

    public void addHuman(Human human){
        treeMan.add(human);
        //return this;
    }

    @Override
    public String toString() {
        return outputTree();
    }
    public String outputTree(){
        StringBuilder sb = new StringBuilder();
        int j=0;
        for (Human human : treeMan ){
            j++;
            sb.append(j+" "+human.outputHuman()+"\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator <Human> iterator(){
        return new HumanIterator(this.treeMan);
    }

    public void sortByName(){
        treeMan.sort(new HumanComparatorByName());
    }

    public void sortByBirn(){
        treeMan.sort(new HumanComparatorByBirn());
    }

}
