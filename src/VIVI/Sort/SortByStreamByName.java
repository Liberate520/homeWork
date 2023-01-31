package VIVI.Sort;

import Homework_6.Designer_Human;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class SortByStreamByName implements ISort{
    Designer_Human designer_human;
    @Override
    public void sort() {
        Stream<Designer_Human> stream = stream(new Designer_Human[]{designer_human});
        stream.filter(humans -> Boolean.parseBoolean(humans.getName()));

    }
}
