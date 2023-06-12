package view;

import java.io.IOException;

public class MainMenu {
    public MainMenu() {
    }

    public void printMenu(){
        System.out.println("1: Сохранить данные в файл;");
        System.out.println("2: Загрузить данные из файла;");
        System.out.println("3: Вывести данные (сорт. по имени);");
        System.out.println("4: Вывести данные (сорт. по дате рождения);");
        System.out.println("0: Завершение работы.");
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        ConsoleUI consoleUI = new ConsoleUI();
        System.out.println("Выбрано: " + choice); // удалить это!
        switch(choice){
            case(1):
                consoleUI.loadData();
                break;
            case(2):
                consoleUI.saveData();
                break;
            case(3):
                consoleUI.printSortByName();
                break;
            case(4):
                consoleUI.printSortByDOB();
                break;
            case(0):
                consoleUI.finish();
                break;
            default:
                System.out.println("Ошибка!");
                break;
        }
    }
}
