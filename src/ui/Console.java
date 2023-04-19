package ui;

import presenter.Presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
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
    public void print(String text){
        System.out.println(text);
    }

    public void finish(){
        work = false;
    }

    public void addHuman(){
        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите дату рождения (пример: 1994-06-16): ");
        String dateOfBirth = scanner.nextLine();
        if (!dateOfBirth.matches("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}")){
            dateOfBirth = scanner.nextLine();
        }
        List<String> human = new ArrayList<>();
        Collections.addAll(human, firstName, lastName, dateOfBirth);
        presenter.addHuman(human);
        System.out.println("человек добавлен");
    }

    public void delHuman() {
        System.out.println("Введите ID объекта для его удаления: ");
        String strID = scanner.nextLine();
        try {
            int id = Integer.parseInt(strID);
            presenter.delHuman(id);
        }
        catch (NumberFormatException e) {
            System.out.println("Неверный ввод");
        }
    }
    public void searchHuman() {
        System.out.println("Введите Фамилию для поиска");
        String lastName = scanner.nextLine();
        presenter.searchHuman(lastName);
    }
    public void saveList() {
        System.out.println("Введите имя файла");
        String nameToFile = scanner.nextLine();
        presenter.saveList(nameToFile);
    }
    public void loadFile() {
        System.out.println("Введите имя файла");
        String nameFile = scanner.nextLine();
        presenter.loadList(nameFile);
    }
    public void showList(){
        presenter.showList();
    }
}