package src.ui;

import src.ui.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Options> commands;
    private Console console;
    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new ShowTree(console));
        commands.add(new ShowHumans(console));
        commands.add(new FindHumans(console));
        commands.add(new InfoHuman(console));
        commands.add(new AddHuman(console));
        commands.add(new SaveTree(console));
        commands.add(new CloseMenu(console));
        commands.add(new DelHuman(console));

    }

    public void execute(int num) throws IOException {
        if(commands.size() >= num) {
            Options options = commands.get(num - 1);
            options.execute();
        } else {
            System.out.println("Некорректно выбран элемент меню!");
        }

    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1).append(" : ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
