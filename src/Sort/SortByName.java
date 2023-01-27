package Sort;

import Homework_6.Designer_Human;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName implements ISort {

    //Сортировка по имени.
    Designer_Human designer_human;
//    public List<Designer_Human> designer_human;
    @Override
    public void sort() {
        designer_human.getHumans().sort(Comparator.comparing(Designer_Human::getName));
    }


}
