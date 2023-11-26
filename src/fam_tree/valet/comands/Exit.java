package fam_tree.valet.comands;

import fam_tree.valet.Look;

public class Exit extends Instruction {

    public Exit(Look look) {
        super("Выход", look);
    }

    public void execute() {
        look.exit();
    }
}
