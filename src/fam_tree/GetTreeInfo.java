package fam_tree;

public class GetTreeInfo extends Instruction {


    public GetTreeInfo (Look look) {
        super("Узнать про семью", look);
    }

    public void execute(){
        look.getTreeInfo();
    }
}
