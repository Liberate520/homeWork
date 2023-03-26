package MyNote.UI;

import java.util.List;
import java.util.Scanner;

import MyNote.Presenter;
import MyNote.Record;

public class Menu {
    
    private Scanner scanner;
    private ConsoleView view;
    private Presenter presenter;

    public Menu(Presenter presenter, ConsoleView view) {
        this.presenter = presenter;
        this.view = view;
        scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("Выберите команду:");
            System.out.println("1 - добавить запись");
            System.out.println("2 - вывести список записей");
            System.out.println("3 - удалить запись");

            int command = scanner.nextInt();
            scanner.nextLine(); 

            switch (command) {
                case 1:
                    String text = view.getText();
                    presenter.addRecord(text);
                    break;
                case 2:
                    List<Record> records = presenter.getAll();
                    if (records.isEmpty()) {
                        System.out.println("Нет записей");
                    } else {
                        view.printNoteBook(records);
                    }
                    break;
                case 3:
                    List<Record> recordss = presenter.getAll();
                if (recordss.isEmpty()) {
                    System.out.println("Нет записей");
                } else {
                   
                    presenter.removeRecord();
                    System.out.println("Запись удалена");
                }
                break;
                default:
                    System.out.println("Неверная команда");
            }
        }
    }


}
