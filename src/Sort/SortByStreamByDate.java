package Sort;

import Homework_6.Designer_Human;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortByStreamByDate implements ISort{
    Designer_Human designer_human;
    @Override
    public void sort() {
        Arrays.stream(new Designer_Human[]{designer_human}).sorted(Comparator.comparing(Designer_Human::getDate)).
                forEach(System.out::println);
    }
}

