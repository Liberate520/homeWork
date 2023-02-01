package VIVI.Print;

import Homework_6.Designer_Human;

import java.util.List;

public class PrintList implements IPrintList {
    @Override
    public void printList(List<Designer_Human> humans) {
        System.out.println(humans);

    }

}
