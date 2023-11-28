package fam_tree.human;

import fam_tree.valet.Valet;
import fam_tree.valet.comands.Instruction;
import fam_tree.valet.Look;

public class AddHuman extends Instruction {


    public AddHuman(Look look) {
        super("Добавить родственника", look);
    }

    public void execute(){
        Valet look = null;
        look.addHumanToTheFamily();
    }
}
