package Print;

import Homework_5.Designer_Human;

import java.util.List;

public class PrintListInFor implements InterfacePrintList {
    @Override
    public void printList(List<Designer_Human> humans) {
        for (Designer_Human HHE : humans) {
            System.out.println(HHE);
        }
        System.out.println();
    }

    }
