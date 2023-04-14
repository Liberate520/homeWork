package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> mainCommands;
    private List<Command> editTreeCommands;

    public Menu(ConsoleUI consoleUI) {
        mainCommands = new ArrayList<>();
        mainCommands.add(new NewFTree(consoleUI));
        mainCommands.add(new RequestEdit(consoleUI));
        mainCommands.add(new RequestLoad(consoleUI));
        mainCommands.add(new RequestSave(consoleUI));
        mainCommands.add(new RequestPrint(consoleUI));
        mainCommands.add(new Quit(consoleUI));

        editTreeCommands = new ArrayList<>();
        editTreeCommands.add(new NewMember(consoleUI));
        editTreeCommands.add(new NewTwin(consoleUI));
        editTreeCommands.add(new AddChild(consoleUI));
        editTreeCommands.add(new AddMarried(consoleUI));
        editTreeCommands.add(new QuitMenu(consoleUI));
    }

    public int getSizeMainCommands() {
        return mainCommands.size();
    }

    public int getSizeEditTreeCommands() {
        return editTreeCommands.size();
    }

    public boolean executeMainCommands(int nMenu) {
        return mainCommands.get(nMenu - 1).execute();
    }

    public boolean executeEditTreeCommands(int nMenu) {
        return editTreeCommands.get(nMenu - 1).execute();
    }

    public String printMainCommands() {
        StringBuilder result = new StringBuilder();
        result.append("Введите что хотите сделать:\n");
        for (int i = 0; i < mainCommands.size(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(mainCommands.get(i).getDescription() + "\n");
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
