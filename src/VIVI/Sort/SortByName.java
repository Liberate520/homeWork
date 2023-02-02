package VIVI.Sort;

import Homework_6.Designer_Human;
import Homework_6.Femily_Tree;

import java.util.Comparator;

;

public class SortByName implements ISort {

    //Сортировка по имени.
    Designer_Human designer_human;
    Femily_Tree femily_tree;
    @Override
    public void sort() {
        designer_human.getHumans().sort(Comparator.comparing(Designer_Human::getName));
        femily_tree.forEach(System.out::println);
    }


}
