package View;

import Presenter.Presenter;
import Repository.RepositoryTree;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private RepositoryTree repository;
    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public String scanString(String str){
        System.out.println(str);
        return scanner.nextLine();
    }
    @Override
    public int scanInt(String str){
        System.out.println(str);
        return scanner.nextInt();
    }
    @Override
    public void start() {
        View view = new ConsoleUI();
        repository = new RepositoryTree();
        presenter = new Presenter(view, repository);
        int menu = scanInt("Выберите нужное действие:" + "\n" +
                "1. Просмотр всех людей " + "\n" +
                "2. Создание человека" + "\n" +
                "3. Просмотр определенного человека " + "\n" +
                "4. Создание связи" + "\n" +
                "Для выхода укажите 0");
        presenter.onClick(menu);
    }
}
