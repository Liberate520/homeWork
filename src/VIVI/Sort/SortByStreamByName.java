package VIVI.Sort;

import Homework_6.Designer_Human;
import Homework_6.Femily_Tree;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class SortByStreamByName implements ISort{
    Femily_Tree femily_tree;
    Designer_Human designer_human;
    @Override
    public void sort() {
        Stream<Designer_Human> stream = stream(new Designer_Human[]{designer_human});
        stream.filter(humans -> Boolean.parseBoolean(humans.getName()));
        femily_tree.forEach(System.out::println);

    }
}
