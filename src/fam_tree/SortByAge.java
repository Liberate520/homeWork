package fam_tree;

public class SortByAge extends Instruction{
    public SortByAge(Look look) {
        super("Сортировать по возрасту", look);
    }

    public void execute() {
        look.sortByAge();
    }
}
