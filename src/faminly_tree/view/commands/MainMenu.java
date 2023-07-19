package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    public MainMenu(ConsoleUI console){
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(console)); //Добавить человека в семейное древо
        commandList.add(new ShowAllTree(console)); //Показать всех людей в семейном древе
        commandList.add(new AddConnection(console)); //Добавить связь ребенок-родитель для имеющихся в дереве людей
        //Найти родителей человека
        //Добавить отца/мать/ребенка имеющегося в дереве человека (возможно взаимозаменяющие пункты этот и выше)
        commandList.add(new NextOfKin(console));//Показать ближайших родственников человека и степень родства
        commandList.add(new SortByID(console)); //Отсортировать всех людей в семеном древе по id
        commandList.add(new SortByName(console)); //Отсортировать всех людей в семеном древе по имени
        commandList.add(new SortByAge(console)); //Отсортировать всех людей в семеном древе по возрасту
        commandList.add(new ReturnToFirstMenu(console)); //Вернуться к статовому меню
        commandList.add(new Finish(console)); //Завершение работы
    }
    public String getMenu(){
        StringBuilder sb = new StringBuilder("Выберите действие:\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}