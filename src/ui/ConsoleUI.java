package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


import presenter.Presenter;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private HashMap<String, String> data;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in, "CP866");
        this.menu = new Menu(this);
        this.data = new HashMap<String, String>();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {
        while (true) {
            menu();
            presenter.onClick(data);
        }
    }

    @Override
    public void menu() {
        data.put("selector", "");
        while (true) {
            System.out.println(printMenu());
            data.put("selector", scan());
            if (checkInput(data.get("selector"))) {
                menu.execute(Integer.parseInt(data.get("selector")));
                return;
            } else {
                System.out.println("Не верное значение.");
            }
        }
    }

    private String scan() {
        System.out.println("Введит значение: ");
        return scanner.next();
    }

    private boolean checkInput(String text) {
        return text.matches("[1-"+ menu.size() +"]+");
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~~~~~~~~~~~\n");
        for (int i = 0; i < menu.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(menu.getCommands().get(i).description());
            stringBuilder.append("\n");            
        }
        return stringBuilder.toString();
    }

    @Override
    public void сompleteDatEntry() {
        data.put("name", getName("пользователя"));
        data.put("surname", getSurname("пользователя"));
        data.put("sex", getSex());
        data.put("startDate", getStartDate());
        data.put("endDate", getEndDate());
        data.put("nameMother", getName("матери"));
        data.put("surnameMother", getSurname("матери"));
        data.put("nameFather", getName("отца"));
        data.put("surnameFather", getSurname("отца"));
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public HashMap<String, String> getData() {
        return data;
    }

    @Override
    public String getName(String status) {
        System.out.printf("Введит имя %s: \n", status);
        return scanner.next();
    }

    @Override
    public String getSurname(String status) {
        System.out.printf("Введит фамилию %s: \n", status);
        return scanner.next();
    }

    public String getStartDate() {
        System.out.println("Введит год рождения: ");
        return scanner.next();
    }

    public String getEndDate() {
        System.out.println("Введит год ухода: ");
        return scanner.next();
    }

    public String getSex() {
        System.out.println("Введит пол (Male, Female): ");
        return scanner.next();
    }

}
