package Search;

import Homework_6.Designer_Human;
import Homework_6.Femily_Tree;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;

public class SearchName implements ISearch {
    Designer_Human designer_human;
    Femily_Tree femily_tree;

    @Override
    public void search(List<Designer_Human> humans) {
        Scanner iScanner = new Scanner(in);
        String name = iScanner.nextLine();
        for (Designer_Human human : humans) {
            if (Objects.equals(human.getName(), name)) {
                humans.add((Designer_Human) designer_human.getHumans());
                femily_tree.forEach(System.out::println);
            }
        }
    }
}

