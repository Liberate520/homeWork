package view.console;

import java.util.ArrayList;
import view.console.commands.*;

public class MainMenu {
    ConsoleUI consoleUI;
    private ArrayList<Command> commands = new ArrayList<Command>();

    public MainMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        commands.add(new LoadTree(consoleUI));
        commands.add(new NewTree(consoleUI));
        commands.add(new SaveTree(consoleUI));
        commands.add(new SortByHierarchyLevel(consoleUI));
        commands.add(new PrintTree(consoleUI));
        commands.add(new AddNewHumanInTree(consoleUI));
        commands.add(new SetCurrentHumanById(consoleUI));
        commands.add(new GetCurrentHumanFullInfo(consoleUI));
        commands.add(new SetBirthDateToCurrHuman(consoleUI));
        commands.add(new SetDeathDateToCurrHuman(consoleUI));
        commands.add(new SetParentToCurrHumanById(consoleUI));
        commands.add(new AddChildToCurrHumanById(consoleUI));
        commands.add(new Exit(consoleUI));
    }

    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < commands.size(); i++) {
            sb.append(i + 1);
            sb.append(" - ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        sb.append(i + 1);
        sb.append(" - ");
        sb.append("показать команды\n");
        return sb.toString();
    }

    public void execute(int commandNumber) {
        if (commandNumber > 0 && commandNumber < commands.size() + 1) {
            commands.get(commandNumber - 1).execute();
        }
        else if (commandNumber == commands.size() + 1) {
            consoleUI.print(getMenu());
        }
        else {
            consoleUI.print("Нет такой команды\nВот список команд:\n");
            consoleUI.print(getMenu());
        }
    }
}