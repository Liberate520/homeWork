package Tree.ui;

import Tree.ui.commands.Option;
import Tree.ui.commands.components.*;

import java.util.ArrayList;
import java.util.List;

// класс работающий с командами меню
public class Menu {
    private final List<Option> commands;
    private Console console;

    // конструктор
    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new OutputAList(console));         // 1 - Показать дерево полностью;
        commands.add(new SearchByName(console));        // 2 - Поиск человека по имени;
        commands.add(new SortAlfabet(console));         // 3 - Сортировать людей по алфавиту;
        commands.add(new SortByAge(console));           // 4 - Сортировка по году рождения;
        commands.add(new AddHuman(console));            // 5 - Добавить нового человека;
        commands.add(new DeletePerson(console));        // 6 - Удалить человека;
        commands.add(new ClearTree(console));           // 7 - Очистить дерево
        commands.add(new CompletionOfWorkSave(console));// 8 - Завершить работу с сохранением изменений.
        commands.add(new CompletionOfWork(console));    // 9 - Завершить работу без сохранения изменений.

    }

    // геттер
    public List<Option> getCommands() {
        return commands;
    }

    // метод возвращает команду по соответствующему номеру
    void execute(int num) {
        Option option = commands.get(num - 1);
        option.execute();
    }

    // метод вывода команд управления на печать
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(" - ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
