package fam_tree;

public class AddHuman extends Instruction {


    public AddHuman(Look look) {
        super("Добавить родственника", look);
    }

    public void execute(){
        look.addHumanToTheFamily();
    }
}
