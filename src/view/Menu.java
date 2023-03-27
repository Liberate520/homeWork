package view;

import view.operations.*;

import java.util.Map;
import java.util.TreeMap;

public class Menu {
    private final TreeMap<String, ViewTasker> commands;

    public Menu(ConsoleUI consoleUI) {
        this.commands = new TreeMap<>();
        this.commands.put("1", new PrintAll(consoleUI));
        this.commands.put("2", new AddTask(consoleUI));
        this.commands.put("3", new DeleteTask(consoleUI));
        this.commands.put("4", new ChangeTask(consoleUI));
        this.commands.put("5", new SaveChanges(consoleUI));
        this.commands.put("6", new LoadTask(consoleUI));
        this.commands.put("7", new Exit(consoleUI));
    }

    public String printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nМЕНЮ:\n");
        for (Map.Entry<String, ViewTasker> item: this.commands.entrySet()) {
            sb.append(item.getValue().optionName());
            sb.append("   - нажмите - ").append(item.getKey()).append("\n");
        }
        sb.append("Ваше решение: ");
        return sb.toString();
    }

    public void execute(String userNumber) {
        if (commands.containsKey(userNumber)) {
            ViewTasker option = commands.get(userNumber);
            option.execute();
        }
        else {
            System.out.printf("В меню нет пункта №: %s", userNumber + ". Введете корректный номер.\n");
        }
    }
}