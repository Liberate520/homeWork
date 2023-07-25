package view.console.menus.mainMenu;

// TODO разбить вот это большое меню на подменю, организовать навигацию по этим меню

import java.util.ArrayList;
import view.console.ConsoleUI;
import view.console.menus.ConsoleMenu;
import view.console.menus.mainMenu.commands.*;

public class MainMenu implements ConsoleMenu {
    ConsoleUI consoleUI;
    private ArrayList<Command> commands = new ArrayList<Command>();

    public MainMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        commands.add(new LoadTree(consoleUI));
        commands.add(new NewTree(consoleUI));
        commands.add(new SaveTree(consoleUI));
        commands.add(new SortByHierarchyLevel(consoleUI));
        commands.add(new PrintTree(consoleUI));
        commands.add(new AddNewItemInTree(consoleUI));
        commands.add(new SetCurrentItemById(consoleUI));
        commands.add(new GetCurrentItemFullInfo(consoleUI));
        commands.add(new SetBirthDateToCurrItem(consoleUI));
        commands.add(new SetDeathDateToCurrItem(consoleUI));
        commands.add(new SetParentToCurrItemById(consoleUI));
        commands.add(new AddChildToCurrItemById(consoleUI));
        commands.add(new Exit(consoleUI));
    }

    @Override
    public String getMenuInfo() {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < commands.size(); i++) {
            sb.append(i + 1);
            sb.append(" - ");
            sb.append(commands.get(i).getDescription()).append("\n");
        }
        sb.append(i + 1);
        sb.append(" - ");
        sb.append("показать команды\n");
        return sb.toString();
    }

    @Override
    public void executeCommand(int number) {
        if (number > 0 && number < commands.size() + 1) {
            commands.get(number - 1).execute();
        }
        else if (number == commands.size() + 1) {
            consoleUI.print(getMenuInfo());
        }
        else {
            consoleUI.print("Нет такой команды\nВот список команд:\n");
            consoleUI.print(getMenuInfo());
        }
    }
}