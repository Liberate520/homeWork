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
    }

    public void sortDate() {
        presenter.sortDate();
    }

    public void search() {
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        presenter.search(surname, name);
    }

    public void load() {
        presenter.load();
    }

    public void save() {
        presenter.save();
    }
}

