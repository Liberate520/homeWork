package view;
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

            if (command.equals("break"))
                break;

            if (command.equals("show:"))
                this.presenter.commandShow();
                
            if (command.contains("id:") && !command.contains("sort by"))
                this.presenter.commandFullPersonInfo(command);
            
            if (command.equals("save:")) 
                this.presenter.commandFileSave();

            if (command.contains("new:"))
                this.presenter.commandAddNewPerson(command);

            if (command.contains("name:"))
                this.presenter.commandSearchPersonByName(command);
            
            if (command.equals("sort by name:"))
                this.presenter.commandShowPersonsSortByName(command);
            
            if (command.equals("sort by id:"))
                this.presenter.commandShowPersonsSortById(command);
            
            if (command.contains("add."))
                this.presenter.commandEditPerson(command);
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
        help.append("add.1679946500.sex.male - Добавить пол id:1679946500\n");
        help.append("add.1679946500.mother.1679946400 - Добавить id:1679946500 - мать id:1679946400\n");
        help.append("add.1679946500.father.1679946400 - Добавить отца, дети добавляются автоматически к родителям\n");
        help.append("name:`имя` - Осуществляет поиск по имени, выводит все похожие\n");
        help.append("save: - сохраняет данные в файл\n");
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

}