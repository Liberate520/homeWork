package view;

import presenter.Presenter;
import java.util.Scanner;

public class MyView implements View {
    private Presenter presenter;
    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);
        printComm();

        while (true) {
            int command = scanner.nextInt();

            if (command == 0)
                CreatyTreeHuman();
            else if (command == 4)
                printAllTree();

            else if (command == 7)
                break;
        }

    }

    private void CreatyTreeHuman() {
        presenter.CreatyTreeHum();
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void printComm() {
        presenter.prinComm();
        ;
    }

    private void printAllTree() {
        presenter.prntAll();
    }
}
