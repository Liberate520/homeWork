package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> mainCommands;
    private List<Command> editTreeCommands;
    private List<Command> sortByCommands;

    public Menu(ConsoleUI consoleUI) {
        mainCommands = new ArrayList<>();
        mainCommands.add(new NewFTree(consoleUI));
        mainCommands.add(new RequestEdit(consoleUI));
        mainCommands.add(new RequestLoad(consoleUI));
        mainCommands.add(new RequestSave(consoleUI));
        mainCommands.add(new RequestPrint(consoleUI));
        mainCommands.add(new SortBys(consoleUI));
        mainCommands.add(new Quit(consoleUI));

        editTreeCommands = new ArrayList<>();
        editTreeCommands.add(new NewMember(consoleUI));
        editTreeCommands.add(new NewTwin(consoleUI));
        editTreeCommands.add(new AddChild(consoleUI));
        editTreeCommands.add(new AddMarried(consoleUI));
        editTreeCommands.add(new PrintTree(consoleUI));
        editTreeCommands.add(new PrintMember(consoleUI));
        editTreeCommands.add(new SortBy(consoleUI));
        editTreeCommands.add(new QuitMenu(consoleUI));

        sortByCommands = new ArrayList<>();
        sortByCommands.add(new SortByFirstName(consoleUI));
        sortByCommands.add(new SortByLastName(consoleUI));
        sortByCommands.add(new SortByGender(consoleUI));
        sortByCommands.add(new SortByBornDate(consoleUI));
    }

    public int getSizeMainCommands() {
        return mainCommands.size();
    }

    public int getSizeEditTreeCommands() {
        return editTreeCommands.size();
    }

    public int getSizeSortByCommands() {
        return sortByCommands.size();
    }

    public boolean executeMainCommands(int nMenu) {
        return mainCommands.get(nMenu - 1).execute();
    }

    public boolean executeEditTreeCommands(int nMenu) {
        return editTreeCommands.get(nMenu - 1).execute();
    }

    public boolean executeSortByCommands(int nMenu) {
        return sortByCommands.get(nMenu - 1).execute();
    }

    public String printMainCommands() {
        StringBuilder result = new StringBuilder();
        result.append("Введите что хотите сделать:\n");
        for (int i = 0; i < getSizeMainCommands(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(mainCommands.get(i).getDescription() + "\n");
        }
        return result.toString();
    }

    public String printEditTreeCommands() {
        StringBuilder result = new StringBuilder();
        result.append("Введите что хотите сделать c генеалогическим древом:\n");
        for (int i = 0; i < getSizeEditTreeCommands(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(editTreeCommands.get(i).getDescription() + "\n");
        }
        return result.toString();
    }

    public String printSortByCommands() {
        StringBuilder result = new StringBuilder();
        result.append("Выберите сортировку:\n");
        for (int i = 0; i < getSizeSortByCommands(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(sortByCommands.get(i).getDescription() + "\n");
        }
        return result.toString();
    }
}
