package ui;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import human.Gender;
import presenter.Presenter;
import tree.Service;

public class Console implements View {
    private Presenter presenter;
    private Service service;
    private PrintInput input;
    private boolean work;
    private Menu mainMenu;


    public Console() {
        work = true;
        mainMenu = new Menu(this);
        this.input = new PrintInput();
    }

    @Override
    public void start() {
        while (work) {
            System.out.println(mainMenu.print());
            int choice = inputNumMenu();
            if (choice == -1){
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = input.nextLine();
        if (!checkLineMenu(line)){
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLineMenu(String line) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    public void addHuman() {
        System.out.println("Введите имя");
        String firstName = input.nextLine();
        System.out.println("Введите фамилию");
        String lastName = input.nextLine();
        System.out.println("Выберите пол:\n1. Мужской\n2. Женский");
        Gender gender = null;
        while (gender == null) {
            String inp = input.nextLine();
            switch (inp) {
                case "1" -> gender = Gender.Male;
                case "2" -> gender = Gender.Female;
                default -> System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
            System.out.println("Введите дату рождения в формате 'дд.мм.гггг'");
            String inp = input.nextLine();
            LocalDate birthDate = LocalDate.parse(inp, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            presenter.addHuman(firstName, lastName, gender, birthDate);
    }

    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void loadFile()
    {
        presenter.loadFile("FamilyTree.bin");
    }

    public void saveFile() {
        if ((input.inputLn("Вы уверены? 1.да 2.нет")).equals("1"))
            presenter.saveFile();
    }

    public void sortTree() {
        System.out.println("""
                Выберите тип сортировки
                1. Имена по алфавиту
                2. По дате рождения""");
        presenter.sortTree(input.nextLine());
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String scan()
    {
        input = new PrintInput();
        return input.nextLine();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
