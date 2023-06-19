package familytree;

import comparator.HumanComparatorByAge;
import comparator.HumanComparatorById;
import comparator.HumanComparatorByName;
import familytree.Tree;
import human.Human;

import java.time.LocalDate;

public class TreeService {
    private Tree tree;

    public TreeService(Tree tree){
        this.tree = tree;

        tree.add(new Human("Иван", "мужской", LocalDate.of(1987,7,15),null));
        tree.add(new Human("Ирина", "женский", LocalDate.of(1980,5,11),null));

        tree.add(new Human("Василина", "женский", tree.findHumanName("Иван"), tree.findHumanName("Ирина"), LocalDate.of(2010,1,1), null));
        tree.add(new Human("Коля", "мужской", tree.findHumanName("Иван"), tree.findHumanName("Ирина"), LocalDate.of(2012,2,2), null));
    }


    public void sortByName(){
        tree.getHumanList().sort(new HumanComparatorByName());
    }

    public void sortById(){
        tree.getHumanList().sort((new HumanComparatorById()));
    }

    public  void sortByAge(){
        tree.getHumanList().sort(new HumanComparatorByAge());
    }
}
