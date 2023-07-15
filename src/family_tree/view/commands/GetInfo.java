package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetInfo extends Command{
    public GetInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Распечатать список людей и регистрации браков";
    }

    public void execute(){
        consoleUI.printInfoTree();
    }
}
