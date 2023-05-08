package Package.View;

import Package.Presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private final Scanner sc;
    private boolean work;
    private final Menu menu;
    private ShowTreeSubMenu showTreeSubMenu;

    public Console() {
        this.sc = new Scanner(System.in);
        this.work = true;
        this.menu = new Menu(this);
        this.showTreeSubMenu = new ShowTreeSubMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work){
            System.out.println(menu.print());
            System.out.print("Ваш выбор: ");
            String choice = sc.nextLine();
            if (check(choice)){
                menu.execute(Integer.parseInt(choice));
            } else{
                fail();
            }
        }
    }

    private boolean check(String text){
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() && Integer.parseInt(text) > 0);
    }

    private boolean thisCheck(String text){
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= showTreeSubMenu.getSize() && Integer.parseInt(text) > 0);
    }

    public void showTree(){
        presenter.showTree();
        System.out.println(showTreeSubMenu.print());
        System.out.print("Ваш выбор: ");
        String thisChoice = sc.nextLine();
        if(thisCheck(thisChoice)){
            showTreeSubMenu.execute(Integer.parseInt(thisChoice));
        } else{
            fail();
        }
    }

    public void addPerson(){
        System.out.print("Введите имя: ");
        String name = sc.nextLine();
        System.out.print("Введите фамилию: ");
        String surname = sc.nextLine();
        System.out.print("Введите дату рождения в формате yyyy-mm-dd: ");
        LocalDate birthDate;
        String bDate = sc.nextLine();
        try {
            birthDate = LocalDate.parse(bDate);
        } catch (Exception e){
            System.out.println("Неверный формат даты!");
            birthDate = null;
        }
        System.out.print("Введите дату смерти в формате yyyy-mm-dd: ");
        LocalDate deathDate;
        String dDate = sc.nextLine();
        try {
            deathDate = LocalDate.parse(dDate);
        } catch (Exception e){
            System.out.println("Неверный формат даты!");
            deathDate = null;
        }
        System.out.print("Введите id отца: ");
        Integer fatherId;
        String fId = sc.nextLine();
        if (fId.matches("[0-9]+") && Integer.parseInt(fId) >= 0 && Integer.parseInt(fId) < presenter.getSize()){
            fatherId = Integer.parseInt(fId);
        } else {
            fatherId = null;
        }
        System.out.print("Введите id матери: ");
        Integer motherId;
        String mId = sc.nextLine();
        if (mId.matches("[0-9]+") && Integer.parseInt(mId) >= 0 && Integer.parseInt(mId) < presenter.getSize()){
            motherId = Integer.parseInt(mId);
        } else {
            motherId = null;
        }
        presenter.addPerson(name, surname, birthDate, deathDate, fatherId, motherId);
    }

    public void deletePerson(){
        System.out.println("Выберите id человека, которого хотите удалить из дерева: ");
        String choice = sc.nextLine();
        if (choice.matches("[0-9]+") && Integer.parseInt(choice) > 0 && Integer.parseInt(choice) <= presenter.getSize()){
            int id = Integer.parseInt(choice);
            presenter.deletePerson(id);
            System.out.println("Указанный человек успешно удален из дерева!\n");
        } else {
            System.out.println("Указанный id в дереве не значится! " +
                    "Посмотрите еще раз всё дерево и выберите правильный id.\n");
        }

    }

    public void exit(){
        System.out.println("Работа с деревом завершена!");
        this.work = false;
    }

    public void fail(){
        System.out.println("Неверный ввод!");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void save() {
        try {
            presenter.save();
            System.out.println("Данные успешно сохранены!\n");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить изменения!\n");
        }
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortBySurname() {
        presenter.sortBySurname();
    }

    public void sortByBirthdate() {
        presenter.sortByBirthdate();
    }

    public void getBackToMenu() {

    }
}
