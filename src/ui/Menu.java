package ui;


import ui.userCommands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;
    private List<Command> editTreeCommands;

    public Menu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new CreateTree(consoleUI));
        commands.add(new EditTree(consoleUI));
        commands.add(new LoadTree(consoleUI));
        commands.add(new SaveTrees(consoleUI));
        commands.add(new PrintTrees(consoleUI));
        commands.add(new Quit(consoleUI));

        editTreeCommands = new ArrayList<>();
        editTreeCommands.add(new CreateSample(consoleUI));
        editTreeCommands.add(new AddChildren(consoleUI));
        editTreeCommands.add(new AddMarried(consoleUI));
        editTreeCommands.add(new PrintTree(consoleUI));
        editTreeCommands.add(new PrintSample(consoleUI));
        editTreeCommands.add(new QuitMenu(consoleUI));
    }

    public int getSizeMainCommands() {
        return commands.size();
    }

    public int getSizeEditTreeCommands() {
        return editTreeCommands.size();
    }

    public boolean executeMainCommands(int nMenu) {
        return commands.get(nMenu - 1).execute();
    }

    public boolean executeEditTreeCommands(int nMenu) {
        return editTreeCommands.get(nMenu - 1).execute();
    }

    public String printMainCommands() {
        StringBuilder result = new StringBuilder();
        result.append("Введите что хотите сделать:\n");
        for (int i = 0; i < commands.size(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(commands.get(i).getDescription() + "\n");
        }
        return result.toString();
    }

    public String printEditTreeCommands() {
        StringBuilder result = new StringBuilder();
        result.append("Введите что хотите сделать c генеалогическим древом:\n");
        for (int i = 0; i < editTreeCommands.size(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(editTreeCommands.get(i).getDescription() + "\n");
        }
        return result.toString();
    }
}
