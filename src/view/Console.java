package view;

import java.util.Scanner;

import model.Animal;
import presenter.Presenter;

public class Console<T extends Animal> implements View<T> {

    private Presenter<T> presenter;
    private Scanner scanner;
    
    // public Console(Scanner scanner) {
    //     scanner = new Scanner(System.in);
    // }

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void setPresenter(Presenter<T> presenter) {
        this.presenter = presenter;    
    }

    @Override
    public void start() {
        int choice = 0;
        while (choice < 7) {
            choice = scan();
            if (choice < 6) {
                presenter.onClick(choice);
            } else {
                System.out.println("Работа завершена");
                break;
            } 
        }
        
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
    
    public int scan() {
        System.out.println("""
            Генеалогическое древо: 
            0 - Показать все, 1 - Поиск по имени, 2 - Сортировка по алфавиту, 3 - Сортировка по году рождения, 
            4 - сериализация, 5 - десериализация, 6 - Выход""");
        System.out.print("Выберите номер пункта: ");
        int res = scanner.nextInt();
        return res;
    }

    public String searchSetName() {
        System.out.print("Введите имя для поиска: ");
        return scanner.next();
    }
}
