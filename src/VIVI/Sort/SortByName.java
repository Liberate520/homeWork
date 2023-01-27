package VIVI.Sort;

import Homework_6.Designer_Human;

import java.util.Comparator;

public class SortByName implements ISort {

    //Сортировка по имени.
    Designer_Human designer_human;
//    public List<Designer_Human> designer_human;
    @Override
    public void sort() {
        designer_human.getHumans().sort(Comparator.comparing(Designer_Human::getName));
    }


}
