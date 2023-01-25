package Print;

import Homework_5.Designer_Human;

import java.util.List;

public class PrintList implements InterfacePrintList{
    @Override
    public void printList(List<Designer_Human> humans) {
        System.out.println(humans);

    }

}
