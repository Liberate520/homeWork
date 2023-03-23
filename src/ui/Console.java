package ui;

import presenter.Presenter;
import java.io.IOException;
import java.util.Scanner;

public class Console implements View{
    private Menu menu;
    private Boolean flag;
    private Presenter presenter;
    private Validator validator;
    private Scanner scanner = new Scanner(System.in);



    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void start() throws Exception {
        menu=new Menu(this);
        flag=true;
        validator=new Validator();
        while (flag){
            printMenu();
            menu.execute(validator.checkInput(scanner.next(),menu.getMenuRowsValue()));
        }
    }

    private void printMenu() {
        System.out.println(menu.printMenu());
    }
    public void finish(){
        flag=false;
    }
    public void myNotes(){
        System.out.println("Заполнение блокнота тестовый");
        System.out.println(presenter.myNotes());
    }
    public void loadData() throws IOException, ClassNotFoundException {
        System.out.println("Загрузить данные");
        System.out.println(presenter.loadData());
    }
    public void saveData() throws Exception {
        System.out.println("Сохранить заметки");
        System.out.println(presenter.saveData());
    }
    public void addNotes(){
        System.out.println("Введите вашу заметку");
        String notes = scanner.next();
        System.out.println(presenter.addNotes(notes));
    }
    public void deleteNotes(){
        System.out.println("Удаление заметки ");
        System.out.println("Введите какую заметку хотите удалить: ");
        Integer number = scanner.nextInt();
        System.out.println(presenter.deleteNotes(number));
    }
    public void printNotes(){
        System.out.println("Все заметки ");
        System.out.println(presenter.printNotes());
    }





}
