package View;

import Presenter.Presenter;

import java.util.Scanner;

public class ViewConsole extends View{

    private Presenter presenter;
    private Boolean flag;
    private Scanner scanner;
    private Menu menu;


    public ViewConsole(){
        scanner = new Scanner(System.in);
        flag = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {


        while (flag) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if (check(choice)) {
                menu.execute(Integer.parseInt(choice));
            } else {
                System.out.println("Неверный номер пункта");
            }
        }
    }



    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void exit(){
        System.out.println("До свидания!");
        flag = false;
    }

    public void addElement(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        System.out.println("Введите пол");
        String gender = scanner.nextLine();

        System.out.println(presenter.addElement(name,surname, gender));
    }

    public Boolean check(String text){
        return (text.matches("[0-9]") && Integer.parseInt(text) <= (menu.getSize()-1)&& Integer.parseInt(text) >=0);
    }


    public void addChildren() {
        System.out.println("Введите имя кому хотите добавить ребенка");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию кому хотите добавить ребенка");
        String surname = scanner.nextLine();
        System.out.println("Введите имя ребенка");
        String nameChildren = scanner.nextLine();
        System.out.println("Введите фамилию ребенка");
        String surnameChildren = scanner.nextLine();
        System.out.println("Введите пол ребенка");
        String genderChildren = scanner.nextLine();
        System.out.println(presenter.addChildren(presenter.getElement(name, surname),nameChildren, surnameChildren, genderChildren));


    }

    public void ElementInfo(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        System.out.println(presenter.getElementInfo(name, surname));

    }


    public void addParent() {
        System.out.println("Введите имя кому хотите добавить родителя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию кому хотите добавить родителя");
        String surname = scanner.nextLine();
        System.out.println("Введите имя родителя");
        String nameParent = scanner.nextLine();
        System.out.println("Введите фамилию родителя");
        String surnameParent = scanner.nextLine();
        System.out.println("Введите пол родителя");
        String genderParent = scanner.nextLine();
        System.out.println(presenter.addParent(presenter.getElement(name, surname),nameParent, surnameParent, genderParent));

    }

    public void DeleteObject(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        System.out.println(presenter.deleteObject(name, surname));

    }

    public void allObjectInfo() {
        System.out.println(presenter.allObjectInfo());
    }
}