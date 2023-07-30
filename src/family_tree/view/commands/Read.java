package family_tree.view.commands;

import family_tree.view.ConsoleUi;

public class Read extends Command{
    public Read(ConsoleUi consoleUi){
        super(consoleUi, ": Показать сохранённое дерево ");
    }
    public void execute(){
        consoleUi.read();
    }
}
