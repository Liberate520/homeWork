package view.consoleUI.menu;

import view.consoleUI.commands.*;
import view.consoleUI.notifications.NoticeType;

import java.util.ArrayList;
import java.util.List;

/**
 * Динамическое меню с возможностью перелистывания страниц с командами, команды 8, 9, 0 зарезервинованы под
 * Предыдущая страница, Следующая страница и Отмена соответственно.
 */
abstract public class FlipMenu extends Menu {
    private final List<Command> commands = new ArrayList<>();
    private final List<Command> SERVICES = new ArrayList<>();
    int currentPage = 0;
    final int SIZE = 7;

    public FlipMenu(String title, boolean oneTimeLoop) {
        super(title, oneTimeLoop);
        this.SERVICES.add(new PreviousPage());
        this.SERVICES.add(new NextPage());
        this.SERVICES.add(new Cancel());
    }

    @Override
    public void run() {
        do {
            clearCommands();
            fillCommands();
            clearConsole();
            notifier.showNotices();
            printTitle();
            printCommands();
            printPagesCounter();

            try {
                System.out.print("Введите команду >: ");
                String input = scanner.nextLine();
                int commandNumber = Integer.parseInt(input) - 1;

                if (commandNumber == -1) {
                    commandNumber = 9;
                }

                if (commandNumber >= 0 && commandNumber < SIZE) {
                    commands.get(currentPage * SIZE + commandNumber).execute(this);
                } else if (commandNumber >= SIZE && commandNumber <= SIZE + SERVICES.size()) {
                    SERVICES.get(commandNumber - SIZE).execute(this);
                } else {
                    notifier.add("Неверная команда", NoticeType.ERROR);
                }
            } catch (NumberFormatException e) {
                notifier.add("Неверная команда", NoticeType.ERROR);
            }
        } while (running);
    }

    public void incrementPage() {
        if (currentPage + SIZE < commands.size()) currentPage += 1;
    }

    public void decrementPage() {
        if (currentPage > 0) currentPage -= 1;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void clearCommands(){
        commands.clear();
    }

    abstract protected void fillCommands();

    protected void printCommands() {
        // Пронумерованный пункты меню
        for (int i = currentPage * SIZE; i < commands.size() && i < (currentPage + 1) * SIZE; i++) {
            System.out.printf("\t%d. %s\n", (i + 1 - (currentPage * SIZE)), commands.get(i).getDescription());
        }
        // Предыдущая страница
        if (currentPage > 0) {
            System.out.printf("\t%d. %s\n", SIZE + 1, SERVICES.get(0).getDescription());
        }
        // Следующая страница
        if (currentPage * SIZE + SIZE < commands.size()) {
            System.out.printf("\t%d. %s\n", SIZE + 2, SERVICES.get(1).getDescription());
        }
        // Отмена
        System.out.printf("\t%d. %s\n", 0, SERVICES.get(2).getDescription());
    }

    protected void printPagesCounter() {
        // Показываем номер текущей страницы и общее количество страниц, если есть куда листать.
        if (commands.size() > SIZE) {
            System.out.printf("[Страница %d/%d]\n", currentPage + 1, commands.size() / SIZE + 1);
        }
    }
}
