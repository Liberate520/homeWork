package ui.comands;

import ui.ConsoleView;

public class LoadFile extends Command{

    public String getDiscription() {
        return discription;
    }

    public LoadFile(ConsoleView consoleView) {
        super(consoleView);
        discription = "загрузить дерево людей";
    }


    public void execute() {
        consoleView.loadFile();
    }
}
