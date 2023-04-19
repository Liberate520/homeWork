package ui;

import presenter.Presenter;

import javax.sound.midi.Soundbank;
import java.net.InterfaceAddress;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public Console(){
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }
    @Override
    public void start() {
        while(work){
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if(check(choice)){
                menu.execute(Integer.parseInt(choice));
            }else {
                fail();
            }
        }
    }
    private boolean check(String text){
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() && Integer.parseInt(text) > 0;
    }
    private void finish() {
        work = false;
    }
    private void fail(){
        System.out.println("Неверный ввод");
    }
    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию человека");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения форматом дд.мм.уууу");
        String bday = scanner.nextLine();
        System.out.println("Введите имя отца");
        String fatherName = scanner.nextLine();
        System.out.println("Введите фамилию отца");
        String fatherSurname = scanner.nextLine();
        System.out.println("Введите имя матери");
        String motherName = scanner.nextLine();
        System.out.println("Введите фамилию матери");
        String motherSurname = scanner.nextLine();
        presenter.addHuman(name,surname,bday,fatherName,fatherSurname,motherName,motherSurname);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}