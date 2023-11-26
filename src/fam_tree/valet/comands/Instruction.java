package fam_tree.valet.comands;

import fam_tree.valet.Look;

public abstract class Instruction {

    String description;
    public Look look;

    public Instruction(String description, Look look) {
        this.description = description;
        this.look = look;
    }

    public Instruction(Console console) {
        this.description = description;
    }


    public String getDescription(){
        return description;
    }

    public abstract void execute();
}
