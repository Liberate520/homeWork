package ui;

import familyTree.enums.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class Console implements ConsoleUI {
    private Scanner scanner;
    private Presenter presenter;

    public Console() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
    }

    @Override
    public void start() {
        start:
        {
            System.out.println("Старт программы");
            while (true) {
                printMenu();
                switch (scan()) {

                    case "1": {
                        ParserPerson.addPerson(scanner,presenter);
                        // Цель консоли выводить информацию пользователю, для обработки ввода
                        // нужен был дополнительный класс (нарушение 1 принципа SOLID)
                        break;
                    }
                    case "2": {
                        presenter.getTreeInfo();
                        break;
                    }
                    case "3": {
                        presenter.saveTree("./src/familyTree/savedFiles/TreeOfHumans.bin");
                        break;
                    }
                    case "4": {
                        presenter.loadTree("./src/familyTree/savedFiles/TreeOfHumans.bin");
                        break;
                    }
                    case "5": {
                        presenter.sortGender();
                        break;
                    }
                    case "6": {
                        presenter.sortAge();
                        break;
                    }
                    case "7": {
                        presenter.sortName();
                        break;
                    }
                    case "8":{
                        System.out.println("Выберите родителя для ребенка(id)");
                        int idParent;
                        idParent = Integer.parseInt(scan());
                        System.out.println("Выберите ребенка(id)");
                        int idChild;
                        idChild = Integer.parseInt(scan());
                        presenter.addParent(idChild,idParent);
                        break;
                    }
                    case "q": {
                        break start;
                    }
                }
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Для выхода из программы нажмите: q\n\n" +
                           "Выберите пункт меню:\n" +
                           "1. Добавить человека в дерево\n" +
                           "2. Распечатать дерево\n" +
                           "3. Сохранить дерево\n" +
                           "4. Загрузить дерево\n" +
                           "Сортировать дерево по: полу(5), возрасту(6), имени(7)\n" +
                           "8. Добавить ребенка\n"
        );
    }

    private String scan() {
        return scanner.nextLine();
    }

    }
