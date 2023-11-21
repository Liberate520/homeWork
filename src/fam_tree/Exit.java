package fam_tree;

public class Exit extends Instruction{

    public Exit(Look look) {
        super("Выход", look);
    }

    public void execute() {
        look.exit();
    }
}
