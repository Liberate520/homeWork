package family_tree.family_tree.view;

import family_tree.family_tree.model.Gender;
import family_tree.family_tree.model.service.Service;
import family_tree.family_tree.presenter.Presenter;


import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветюли!");
        while (work){
            printMenu();
        }
    }

//    private String scanMenu() {
//        String  choiceStr = scanner.nextLine();
//        // метод проверочки строки
//        int choice = Integer.parseInt(choiceStr);
//        menu.execute(choice);
//        switch (choice){
//            case "1":
//                addHuman();
//                break;
//            case "2":
//                getHumanListInfo();
//                break;
//            case "3":
//                sortByName();
//                break;
//            case "4":
//                sortByAge();
//                break;
//            case "5":
//                finish();
//                break;
//            default:
//                error();
//        }

    private void printMenu(){
        System.out.println(menu.print());
        System.out.println("1. Добавить человека");
        System.out.println("2. Получить список");
        System.out.println("3. Отсортировать по имени");
        System.out.println("4. Отсортировать по возрасту");
    }
    public void finish() {
        System.out.println("Пока !");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {

        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя Human");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (Male/Female)");
        String gender = scanner.nextLine();
        System.out.println("Укажите дату рождения (ГГГГ-ММ-ДД)");
        String birthDate = scanner.nextLine();
        presenter.addHuman(name, gender, birthDate);
    }


    @Override
//    public void answer(String answer) {
//        System.out.println(answer);
    public void printAnswer(String answer) {
        System.out.println(answer);
        }

    }
    // метод сохранения      save(tree);
//    public void save(FamilyTree tree) {
//        FileHandler fileHandler = new FileHandler();
//        String filePath = "src/family_tree/writer/tree.txt";
//        fileHandler.save(tree, filePath);
//    }

    // метод загрузки
//    private void FamilyTree load() {
//        FileHandler fileHandler = new FileHandler();
//        String filePath = "src/family_tree/writer/tree.txt";
//        familyTree = (FamilyTree)fileHandler.read(filePath);
////        return (FamilyTree) fileHandler.read(filePath);
//    }
}

