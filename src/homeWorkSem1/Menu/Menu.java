package homeWorkSem1.Menu;

import java.util.ArrayList;
import java.util.List;

import homeWorkSem1.Option.Option;

public class Menu {
    List<Option> commandList;

    /**Инициализируем список меню */
    public Menu() {
        this.commandList = new ArrayList<>();
    }

    /**Добавляем новую команду в список команд */
    public void add(Option op) {
        commandList.add(op);
    }

    /**Получаем список команд */
    public List<Option> getCommandList() {
        return commandList;
    }

}
