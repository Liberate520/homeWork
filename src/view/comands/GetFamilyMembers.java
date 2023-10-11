package view.comands;

import view.ConsoleUI;

public class GetFamilyMembers extends Comand {
    public GetFamilyMembers(ConsoleUI consoleUI )
    {
        super("Получить список членов семьи", consoleUI );
    }
    @Override
    public void execute() {
        consoleUI.getFamilyMembers();
    }
}
