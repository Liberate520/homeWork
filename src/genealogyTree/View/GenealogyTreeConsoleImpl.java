package View;

import model.Person;

import java.util.List;
import java.util.Scanner;

import Presenter.GenealogyTreePresenter;
import Presenter.GenealogyTreePresenterImpl;

public class GenealogyTreeConsoleImpl implements GenealogyTreeView {
    private GenealogyTreePresenter presenter;
    private Scanner scanner;

    public GenealogyTreeConsoleImpl() {
        presenter = new GenealogyTreePresenterImpl(null);
        presenter.attachView(this);
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayChildren(List<Person> children) {
        if (children.isEmpty()) {
            displayMessage("У этой персоны нет детей.");
        } else {
            displayMessage("Дети персоны:");
            for (Person child : children) {
                System.out.println(child);
            }
        }
    }

    @Override
    public void displayAncestors(List<Person> ancestors) {
        if (ancestors.isEmpty()) {
            displayMessage("У этой персоны нет предков.");
        } else {
            displayMessage("Предки персоны:");
            for (Person ancestor : ancestors) {
                System.out.println(ancestor);
            }
        }
    }

    // Методы для обработки пользовательского ввода и команд
    // ...
}
