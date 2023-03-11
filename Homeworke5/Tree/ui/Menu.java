package ui;

import java.util.ArrayList;
import java.util.List;

import ui.commands.*;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new OutputAList(console));     // 1 - Вывести весь список;
        commands.add(new SortAlfabet(console));     // 2 - Сортировать по алфавиту;
        commands.add(new SortingByYear(console));   // 3 - Сортировка по годам;
        commands.add(new SearchByName(console));    // 4 - Поиск по имени и фамилии;
        commands.add(new AddHuman(console));        // 5 - Добавить нового человека;
        commands.add(new SavingChanges(console));   // 6 - Сохранить изменения;
        commands.add(new CompletionOfWork(console));// 7 - Завершить работу.
    }

    void execute(int num){
        Option option = commands.get(num-1);
        option.execute();
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(" - ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
