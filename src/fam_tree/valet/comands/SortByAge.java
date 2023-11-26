package fam_tree.valet.comands;

import fam_tree.valet.Look;
import fam_tree.valet.comands.Instruction;

public class SortByAge extends Instruction {
    public SortByAge(Look look) {
        super("Сортировать по возрасту", look);
    }

    public void execute() {
        look.sortByAge();
    }
}
