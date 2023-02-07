package homeWorkSem1.Menu;

import java.util.ArrayList;
import java.util.List;

import homeWorkSem1.Option.Add;
import homeWorkSem1.Option.GetGrands;
import homeWorkSem1.Option.GetSisBro;
import homeWorkSem1.Option.GetTree;
import homeWorkSem1.Option.Option;
import homeWorkSem1.Option.SetFather;
import homeWorkSem1.Option.SetMother;

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

    /**создаем меню */
    public List<Option> presentMenu() {
        commandList.add(new Add<>());
        commandList.add(new GetTree());
        commandList.add(new GetGrands<>());
        commandList.add(new GetSisBro<>());
        commandList.add(new SetFather<>());
        commandList.add(new SetMother<>());
        return commandList;
    }

}
