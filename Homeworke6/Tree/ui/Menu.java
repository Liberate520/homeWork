package ui;

import java.util.ArrayList;
import java.util.List;

import ui.commands.*;
import ui.commands.components.*;



public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new Load(console));            // 1 - Загрузить список;
        commands.add(new OutputAList(console));     // 2 - Вывести весь список;
        commands.add(new SearchByName(console));    // 3 - Поиск по имени и/или фамилии;
        commands.add(new SortAlfabet(console));     // 4 - Сортировать по алфавиту;
        commands.add(new SortingByYear(console));   // 5 - Сортировка по годам;
        commands.add(new AddHuman(console));        // 6 - Добавить нового человека;
        commands.add(new DeletePerson(console));    // 7 - Удалить человека;
        commands.add(new SavingChanges(console));   // 8 - Сохранить изменения;
        commands.add(new CompletionOfWork(console));// 9 - Завершить работу.
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

    public List<Option> getCommands() {
        return commands;
    }
}
