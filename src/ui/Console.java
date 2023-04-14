package ui;

import presenter.Presenter;
import ui.interfaces.View;

import java.io.IOException;
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
    public void start() throws IOException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work){
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));
            }else{
                System.out.println("Ошибка ввода команды");
            }
        }
    }
    @Override
    public void print(String text){
        System.out.println(text);
    }
    private void hello(){
        System.out.println(menu.printMenu());
    }
    private boolean checkInput(String text){
        return text.matches("[1-15]+");
    }
    public void finish() {
        work = false;
    }


    public void treeList() {
        System.out.println("Семейное древо: ");
        presenter.treeList();
    }
    public void search() {
        System.out.println("Поиск по: \n" + 
        "1. Имени \n"+
        "2. Фамилии \n"+
        "3. Имени и фамилии \n"+
        "4. По дате рождения \n"+
        "5. По нахождение в живых \n"+ 
        "6. По дате смерти \n" +
        "Введите число: ");
        int i = scanner.nextInt();
        if(i == 1){System.out.println("Введие имя: "); presenter.searchByFirstName(scanner.nextLine());}
        if(i == 2){System.out.println("Введие фамилию: ");presenter.searchBySecondName(scanner.nextLine());}
        if(i == 3){System.out.println("Введие имя и фамилию: ");presenter.searchByFullName(scanner.nextLine());}
        if(i == 4){System.out.println("Введие дату рождения: ");presenter.searchByDateOfBirth(scanner.nextLine());}
        if(i == 5){System.out.println("Выберите число: \n" + "1. Жив \n" + "2. Мертв \n" + "Введите число: ");presenter.searchByAliveOrNot(scanner.nextInt());}
        if(i == 6){System.out.println("Введие дату смерти: ");presenter.searchByDateOfDeath(scanner.nextLine());}
    }

    public void sorting() { 
        System.out.println("Поиск по: \n" + 
        "1. Имени \n"+
        "2. Фамилии \n"+
        "3. По нахождение в живых \n"+ 
        "4. По количеству детей \n" +
        "Введите число: ");
        presenter.sorting(scanner.nextInt());
    }

    public void dateOfBirth(){
        System.out.println("Выберите человека для просмотра даты рождения: ");
        presenter.getAllPersonFromList();
        System.out.println("Введите номер человека: ");
        presenter.dateOfBirth(scanner.nextInt());
    }

    public void parents(){
        System.out.println("Выберите человека для просмотра родителей: ");
        presenter.getAllPersonFromList();
        System.out.println("Введите номер человека: ");
        presenter.dateOfBirth(scanner.nextInt());
    }








    public void save() throws IOException {
        presenter.save();
        System.out.println("Семейное древо успешно сохранено!");
        System.out.println();
    }
    public void read() throws IOException, ClassNotFoundException {
        System.out.println("Загрузка древа из файла");
        presenter.read();
        System.out.println();
    }
}
