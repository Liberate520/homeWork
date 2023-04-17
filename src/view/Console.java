package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import presenter.Presenter;
public class Console implements View{
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    boolean work = true;

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work){
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("что-то пошло не так");
            }
        }
    }

    private boolean checkInput(String text){
        return text.matches("[0-9]+");
    }

    private void hello() {
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void showTree() {
        presenter.showTree();
    }
    public void addHuman() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения (в формате: 16/02/1999):");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String localDate = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(localDate, formatter);
        presenter.addHuman(name, surname, dateOfBirth);
    }

    public void finish(){
        work = false;
    }

    public void sortName() {
        presenter.sortName();
        showTree();
    }

    public void sortDate() {
        presenter.sortDate();
        showTree();
    }

    public void search() {
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        if (presenter.search(surname,name).size() == 3) {
            System.out.println(presenter.search(surname, name).get(0) + " Папа: " + presenter.search(surname, name)
                    .get(1) + " Мама: " + presenter.search(surname, name).get(2));
        } else if (presenter.search(surname,name).size() == 1) {
            System.out.println(presenter.search(surname, name).get(0) + " !Информации о родителей нет!");
        } else System.out.println("Такого чеовека нет!");
    }

    public void load() {
        presenter.load();
    }

    public void save() {
        presenter.save();
    }
}

