package view.consoleUI.menu;


import view.consoleUI.commands.Command;
import view.consoleUI.notifications.NoticeType;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс простого меню без листания
 */
public class SimpleMenu extends Menu {
    protected final List<Command> commands = new ArrayList<>();
    public SimpleMenu(String menuDescription, boolean oneTimeLoop) {
        super(menuDescription, oneTimeLoop);
    }

    @Override
    public void run() {
        do {
            clearConsole();
            notifier.showNotices();
            printTitle();
            printCommands();

            System.out.print("Введите команду >: ");
            String input = scanner.nextLine().trim().toLowerCase();

            try {
                int commandNumber = Integer.parseInt(input);
                if (commandNumber < 1 || commandNumber > commands.size()) {
                    notifier.add("Неверная команда", NoticeType.ERROR);
                } else {
                    Command command = commands.get(commandNumber - 1);
                    command.execute(this);
                }

            } catch (NumberFormatException e) {
                notifier.add("Неверная команда", NoticeType.ERROR);
            }
        } while (running);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    protected void printCommands() {
        for (int i = 0; i < commands.size(); i++) {
            System.out.printf("\t%d. %s%n", i + 1, commands.get(i).getDescription());
        }
    }
}

