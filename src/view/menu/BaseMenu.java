package view.menu;

import view.ConsoleUI;
import view.menu.mainMenu.commands.*;

import java.util.List;

public abstract class BaseMenu  {
    private List<Command> commandList;

    public BaseMenu(List<Command> commandList) {
        this.commandList = commandList;
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

    /**
     * Проверяет, входят ли входные данные в пределы функционала menu
     *
     * @param choice введенные данные
     * @return number menu
     */
    public int checkInputLineMenu(String choice) {
        if (choice.matches("[0-9]+")) {
            int result = Integer.parseInt(choice);
            if (result > 0 && result <= size()) return result;
        }
        return -1;
    }


}

