package view;
import java.io.IOException;
import java.util.Scanner;

import service.Persons.Person;
import service.tree.FamilyTree;
import presenter.Presenter;
import view.starts.Start1;
import view.starts.StartChoice;


public class ConsoleUI<T extends Person, E extends FamilyTree> implements View<T, E> {
    private Scanner scanner;
    private Presenter presenter;

    public static boolean work = true;

    public ConsoleUI() {

        scanner = new Scanner(System.in, "cp866");
    }

    public void exit() {
        System.out.println("Работа завершена");
        scanner.close();
        work = false;
    }



    @Override
    public void start() throws ClassNotFoundException, IOException
    {
        while (work)
        {
            StartChoice startChoice = new Start1();
            int choice = startChoice.start1();

            switch (choice) {
                case 1:
                    presenter.presenterPrintTree();
                    break;
                case 2:
                    presenter.presenterFindHuman();
                    break;
                case 3:
                    presenter.presenterSortByName();
                    break;
                case 4:
                    presenter.presenterSortByDate();
                    break;
                case 5:
                    presenter.presenterSaveData();
                    break;
                case 6:
                    presenter.presenterLoadData();
                    break;
                case 7:
                    exit();
                    break;
                default:
                    break;
            }

        }
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void print(T t) {
        System.out.println(t);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}



