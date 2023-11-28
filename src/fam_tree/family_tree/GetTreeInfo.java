package fam_tree.family_tree;

import fam_tree.valet.comands.Instruction;
import fam_tree.valet.Look;

public class GetTreeInfo extends Instruction {


    public GetTreeInfo (Look look) {
        super("Узнать про семью", look);
    }

    public void execute(){
        look.getTreeInfo();
    }
}
