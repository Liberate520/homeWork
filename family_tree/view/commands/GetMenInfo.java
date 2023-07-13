package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetMenInfo extends Command{

    public GetMenInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список людей мужского пола";
    }

    @Override
    public void execute() {
        consoleUI.getMenInfo();
    }

}
