package family_tree.view.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;
import family_tree.view.commands.TreeMenu;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private  boolean flag;
    private TreeMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new TreeMenu(this);
        flag = true;
    }

    @Override
    public void start() {
        while (flag) {
            System.out.println("Выберите действие");
            System.out.println(menu.menu());
            String act = scanner.nextLine();
            int actInt = Integer.parseInt(act);
            if (actInt >= 0) {
                menu.execute(actInt);
            }
        }
    }

    public void addHuman() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения");
        LocalDate birthDate = inputDate();
        LocalDate deathDate = null;
        System.out.println("Ввести дату смерти?");
        boolean yesorno = inputYesOrNo();
        if(yesorno) {
            System.out.println("Введите дату смерти");
            deathDate = inputDate();
        }
        System.out.println("Введите пол (Female, Male):");
        Gender gender = inputGender();
        presenter.addHuman(name, birthDate, deathDate, gender);
    }

    public LocalDate inputDate () {
        boolean inputDate;
        LocalDate requiredDate = null;
        do {
            System.out.println("Введите год:");
            String year = scanner.nextLine();
            System.out.println("Введите месяц:");
            String month = scanner.nextLine();
            System.out.println("Введите день:");
            String day = scanner.nextLine();
            String date = year + "-" + month + "-" + day;
            inputDate = true;
            try {
                requiredDate = LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                inputDate = false;
                System.out.println("Неверные данные");
            }
        } while(!inputDate);
        return requiredDate;
    }

    public Gender inputGender() {
        boolean inputGender = true;
        Gender humanGender = null;
        do{
            String gender = scanner.nextLine();
            if(gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
                humanGender = Gender.Female;
                inputGender = true;
            }
            else if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")){
                humanGender = Gender.Male;
                inputGender = true;
            } else {
                inputGender = false;
                System.out.println("Неверные данные\n" +
                                    "Повторите ввод");
            }
        } while (!inputGender);
        return humanGender;
    }

    public void addMother(){
        System.out.println("Введите ID матери");
        int motherID = scanner.nextInt();
        System.out.println("Введите ID ребенка");
        int childID = scanner.nextInt();
        presenter.setMother(motherID, childID);
    }

    public void addFather(){
        System.out.println("Введите ID отца");
        int fatherID = scanner.nextInt();
        System.out.println("Введите ID ребенка");
        int childID = scanner.nextInt();
        presenter.setFather(fatherID, childID);
    }

    public void showParentName(){
        System.out.println("Введите ID ребенка");
        int childID = scanner.nextInt();
        System.out.println(presenter.showParentName(childID));
    }

    public void showChildName() {
        System.out.println("Введите ID человека");
        int id = scanner.nextInt();
        System.out.println(presenter.showChildName(id));
    }

    public void showSibling() {
        System.out.println("Введите ID человека");
        int id = scanner.nextInt();
        System.out.println(presenter.showSiblingName(id));
    }

    public void findHumanByID(){
        System.out.println("Введите ID");
        int requiredID = scanner.nextInt();
        System.out.println(presenter.findByID(requiredID));
    }

    public void findHumanByName() {
        System.out.println("Введите имя");
        String requiredHuman = scanner.nextLine();
        System.out.println(presenter.findByName(requiredHuman));
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void  sortByGender() {
        presenter.sortByGender();
    }

    public void showFamilyTree() {
        presenter.showFamilyTree();

    }
    public void finish() {
        flag = false;
    }

    public boolean inputYesOrNo(){
        boolean result = false;
        System.out.println("'y' - да, 'n' - нет");
        String choice = scanner.nextLine();
        switch (choice) {
            case "y" -> {
                result = true;
            }
            case "n" -> {
            }
        }
        return result;
    }

    public void saveFile() {
        System.out.println("Введите полный путь и имя файла");
        String filePath = scanner.nextLine();
        if(!presenter.saveFile(filePath)) {
            System.out.println("Невозможно сохранить объект");
            System.out.println("Введите корректный путь");
        } else {
            presenter.saveFile(filePath);
        }
    }

    public void loadFile() {
        System.out.println("Введите полный путь и имя файла");
        String filePath = scanner.nextLine();
        if(!presenter.loadFile(filePath)){
            System.out.println("Невозможно загрузть объект");
            System.out.println("Введите корректный путь");
        }
        else {
            presenter.showFamilyTree();
        }
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
