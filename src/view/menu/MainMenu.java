package view.menu;

import view.ConsoleUI;
import view.menu.commands.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс MainMenu представляет главное меню консольного пользовательского интерфейса (UI).
 * Содержит список доступных команд и предоставляет методы для выполнения выбранной команды и получения размера меню.
 */
public class MainMenu {
    private List<Command> commandList;

    /**
     * Создает новый объект MainMenu.
     * Инициализирует список команд и добавляет их в список.
     *
     * @param consoleUI объект ConsoleUI для передачи в конструкторы команд
     */
    public MainMenu(ConsoleUI consoleUI) {
        this.commandList = new ArrayList<>();
        this.commandList.add(new AddRecord(consoleUI));
        this.commandList.add(new GetRecord(consoleUI));
        this.commandList.add(new GetParents(consoleUI));
        this.commandList.add(new GetAllRecord(consoleUI));
        this.commandList.add((new SortingTrees(consoleUI)));
        this.commandList.add(new Finish(consoleUI));


    }

    /**
     * Возвращает строку, содержащую отформатированное меню с описаниями команд.
     *
     * @return строка с меню
     */
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    /**
     * Выполняет выбранную команду на основе выбранного пункта меню.
     *
     * @param choice выбранный пункт меню
     */
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    /**
     * Возвращает количество команд в меню.
     *
     * @return количество команд
     */
    public int size() {
        return commandList.size();
    }


}
