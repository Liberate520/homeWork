package family_tree.view.commands;

import family_tree.view.ConsoleUi;

public class Save extends Command{
    public Save(ConsoleUi consoleUi){
        super(consoleUi, ": Сохранить дерево ");
    }
    public void execute(){
        consoleUi.save();
    }
}
