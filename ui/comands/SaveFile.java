package ui.comands;

import ui.ConsoleView;

public class SaveFile extends Command{

    public String getDiscription() {
        return discription;
    }

    public SaveFile(ConsoleView consoleView) {
        super(consoleView);
        discription = "сохранить дерево людей";
    }


    public void execute() {
        consoleView.saveFile();
    }
}