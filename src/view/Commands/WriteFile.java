package view.Commands;

import Model.home_work_class.FamilyTree.FileWriter;
import view.ConsoleUI;

public class WriteFile extends Commands{
    WriteFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Записать семейное дерево";
    }

    @Override
    public void execute() {
        consoleUI.fileWriter();
    }
}
