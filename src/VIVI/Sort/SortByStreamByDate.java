package VIVI.Sort;

import Homework_7.Designer_Human;

import java.util.Arrays;
import java.util.Comparator;

public class SortByStreamByDate implements ISort{
    Designer_Human designer_human;
    @Override
    public void sort() {
        Arrays.stream(new Designer_Human[]{designer_human}).sorted(Comparator.comparing(Designer_Human::getDate)).
                forEach(System.out::println);
    }
}

