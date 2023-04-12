package view;

import java.util.LinkedHashMap;
import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements UI {
    private Scanner scan;
    private String cursor = "$: ";
    private Presenter presenter;

    public ConsoleUI() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public void start() {
        print(helper());
        while (true) {
            String command = commandFromConsole();

             LinkedHashMap<String, String> map = commandParse(command);

            if (map.containsKey("break"))
                break;

            if (map.containsKey("show"))
                this.presenter.commandShow();

            if (map.containsKey("sort by name"))
                this.presenter.commandShowPersonsSortByName();

            if (map.containsKey("sort by id"))
                this.presenter.commandShowPersonsSortById();

            if (map.containsKey("id"))
                this.presenter.commandFullPersonInfo(map.get("id"));

            if (map.containsKey("save as csv"))
                this.presenter.commandFileSaveAsCSV();

            if (map.containsKey("save as binary"))
                this.presenter.commandFileSaveAsBinary();

            if (map.containsKey("new"))
                this.presenter.commandAddNewPerson(map.get("new"));

            if (map.containsKey("name"))
                this.presenter.commandSearchPersonByName(map.get("name"));

            if (map.containsKey("add"))
                if (map.containsKey("sex"))
                    this.presenter.commandEditPerson(map.get("add"), "sex", map.get("sex"));
                if (map.containsKey("mother"))
                    this.presenter.commandEditPerson(map.get("add"), "mother", map.get("mother"));
                if (map.containsKey("father"))
                    this.presenter.commandEditPerson(map.get("add"), "father", map.get("father"));

        }
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    private String helper() {
        StringBuilder help = new StringBuilder();
        help.append("\n\nОсновные комманды консоли:\n");
        help.append("show: - показывает всех участников дерева\n");
        help.append("sort by name: - показывает всех участников дерева с сортировкой по имени\n");
        help.append("sort by id: - показывает всех участников дерева с сортировкой по id\n");
        help.append("id: 1679946500 - показывает подробную информацию о человеке\n");
        help.append("new:`имя` - Добавить нового человека(создает и присваевает id)\n");
        help.append("add:1679946500.sex.male - Добавить пол id:1679946500\n");
        help.append("add:1679946500.mother.1679946400 - Добавить id:1679946500 - мать id:1679946400\n");
        help.append("add:1679946500.father.1679946400 - Добавить отца, дети добавляются автоматически к родителям\n");
        help.append("name:`имя` - Осуществляет поиск по имени, выводит все похожие\n");
        help.append("save as csv: - сохраняет данные в csv файл\n");
        help.append("save as binary: - сохраняет данные в бинарный файл\n");
        return help.toString();
    }

    private String commandFromConsole() {
        System.out.print("\n" + this.cursor);
        String command = scan.nextLine();
        return command;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private LinkedHashMap<String, String> commandParse(String command) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        String[] command_array = command.split(":");
//        System.out.println(Arrays.toString(command_array));
        if (command_array.length > 2 | command_array.length == 0) {
            return map;
        }

        if (command_array.length == 1) {
            map.put(command_array[0], null);
            return map;
        }
        String[] command_info = command_array[1].split("\\.");
        if (command_info.length == 0) {
            map.put(command_array[0], null);
        } else if(command_info.length == 1){
            map.put(command_array[0], command_info[0]);
        } else if (command_info.length == 3){
            map.put(command_array[0], command_info[0]);
            map.put(command_info[1], command_info[2]);
        }

        return map;
    }

}