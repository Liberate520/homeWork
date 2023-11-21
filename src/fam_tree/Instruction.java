package fam_tree;

public abstract class Instruction {

    private final String description;
    Look look;

    public Instruction(String description, Look look) {
        this.description = description;
        this.look = look;
    }


    public String getDescription(){
        return description;
    }

    public abstract void execute();
}
