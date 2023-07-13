package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetWomenInfo extends Command{

    public GetWomenInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список людей женского пола";
    }

    @Override
    public void execute() {
        consoleUI.getWomenInfo();
    }

}
