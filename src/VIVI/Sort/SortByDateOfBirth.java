package VIVI.Sort;

import Homework_6.Designer_Human;
import Homework_6.Femily_Tree;

import java.util.Comparator;

public class SortByDateOfBirth implements ISort {

    Designer_Human designer_human;
    Femily_Tree femily_tree;

    public void sort() {
        designer_human.getHumans().sort(Comparator.comparing(Designer_Human::getDate));
        femily_tree.forEach(System.out::println);
    }

}
