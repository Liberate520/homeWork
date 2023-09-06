package family_tree.FamilyTree.View;

import family_tree.FamilyTree.Model.Person.Gender;
import family_tree.FamilyTree.Presentor.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.work = true;
        this.menu = new MainMenu(this);

    }

    @Override
    public void start() throws IOException {
        int intChoice = 0;
        System.out.println("Добро пожаловать в фамильное дерево\n");
        while (work) {
            System.out.println(menu.printMenu());
            System.out.println("выберите пункт меню:");
            String choice = scanner.nextLine();
            if (choice.matches("[0-9]+")) {
                intChoice = Integer.parseInt(choice);
                if ((intChoice <= menu.getSize()) && (intChoice > 0)) {
                    menu.execute(intChoice);
                }
            } else {
                System.out.println("неправильно выбран пункт меню");
            }
        }
    }

    @Override
    public void printResponse(String response) {
        System.out.println(response);
    }

    public void addPerson() { // добавить в дерево дерево элемент
        boolean flag = true;
        Gender gender = null;
        //String fName, String lName, Gender gen, LocalDate dataB
        System.out.println("введите имя:");
        String fName = scanner.nextLine();
        System.out.println("введите фамилию:");
        String lName = scanner.nextLine();

        while (flag) {
            System.out.println("Укажите пол (m/f):");
            String temp = scanner.nextLine();

            if (temp.equals("m")) {
                gender = Gender.Male;
                flag = false;
            } else if (temp.equals("f")) {
                gender = Gender.Female;
                flag = false;
            }
        }
        flag = true;
        LocalDate dataB = null;
        while (flag) {
            System.out.println("введите дату рождения(дд-мм-гггг):");
            String temp = scanner.nextLine();

            if (temp.matches("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)")) {
                String[] tempDate = temp.split("-");
                dataB = LocalDate.of(Integer.parseInt(tempDate[2]), Integer.parseInt(tempDate[1]), Integer.parseInt(tempDate[0]));
                flag = false;
            }
        }
        presenter.addPerson(fName, lName, gender, dataB);
    }

    public void getTree() { //вывести дерево на экран
        presenter.getTree();
    }

    public void addParent() {
        int innChilgren = -1;
        int innParent = -1;
        System.out.println("введите ИНН ребенка:\n");
        String temp = scanner.nextLine();
        if (temp.matches("[0-9]+")) {
            innChilgren = Integer.parseInt(temp);
        }
        System.out.println("введите ИНН родителя:\n");
        temp = scanner.nextLine();
        if (temp.matches("[0-9]+")) {
            innParent = Integer.parseInt(temp);
        }

        presenter.addParent(innChilgren, innParent);

    }

    public void marriage() {
        int innFPartner = -1;
        int innSPartner = -1;
        System.out.println("введите ИНН первого партнера:\n");
        String temp = scanner.nextLine();
        if (temp.matches("[0-9]+")) {
            innFPartner = Integer.parseInt(temp);
        }
        System.out.println("введите ИНН второго партнера:\n");
        temp = scanner.nextLine();
        if (temp.matches("[0-9]+")) {
            innSPartner = Integer.parseInt(temp);
        }
        presenter.marriage(innFPartner, innSPartner);

    }

    public void divorce() {
        int innFPartner = -1;
        int innSPartner = -1;
        System.out.println("введите ИНН первого партнера:");
        String temp = scanner.nextLine();
        if (temp.matches("[0-9]+")) {
            innFPartner = Integer.parseInt(temp);
        }
        System.out.println("введите ИНН второго партнера:");
        temp = scanner.nextLine();
        if (temp.matches("[0-9]+")) {
            innSPartner = Integer.parseInt(temp);
        }
        presenter.divorce(innFPartner, innSPartner);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    //TODO доделать чтобы можно было указывать путь к файлу и проверку что есть такой путь. либо его создавать
    public void importToFile() throws IOException {
        System.out.println("введите имя файла (откуда загрузить) ");
        String namefile = scanner.nextLine();
        presenter.importToFile(namefile);
    }

    public void exportFromFile() throws IOException {
        System.out.println("введите имя файла (куда выгрузить)");
        String namefile = scanner.nextLine();
        presenter.exportFromFile(namefile);
    }

    public void finish() {
        System.out.println("Работа закончена. До свидание");
        work = false;
    }

}
