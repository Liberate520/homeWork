package view;
/**
 * класс реализации интерфейса по средствам терминала
 */
import model.OutputTree;
import model.Person;
import org.json.JSONException;
import presenter.Controller;

import java.util.Scanner;
public class ConsoleTerminal extends Console<Controller> implements View, OutputTree<Person> {
    //private Controller controller;
    private Scanner scanner;

    public ConsoleTerminal() {
        scanner = new Scanner(System.in);
        controller = super.getController();
        //scanner = new Scanner(System.in, "Cp866");
    }

    @Override
    public void start() throws JSONException {
        super.controller.onClick();
    }

    @Override
    public String scanOne(String s) {
        System.out.println(s);
        scanner.nextLine();
        return scanner.nextLine();
    }

    @Override
    public String scanOther(String s) {
        System.out.println(s);
        return scanner.nextLine();
    }

    @Override
    public void printStr(String s) {
        System.out.println(s);
    }

    @Override
    public int printMenu(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }


    @Override
    public void printTree(Person person) {
        if (person.getMyChildren() == null) {
            printStr(person.getMyName());
        } else {
            if (person.getMyParent() == null){
                printStr(person.getMyName());
            }
            else {
                printStr("родитель: " + person.getMyParent() + " - потомок: " + person.getMyName());
            }
            for (Person p : person.getMyChildren()) {
                printTree(p);
            }
        }

    }
    @Override
    public void printChildren(String Name, Person person) {
        if (person.getMyName().equals(Name)) {
            printStr("родитель - " + person.toString());
            for (Person p : person.getMyChildren()) {
                printStr("ребенок - " + p.getMyName());
            }
        } else {
            for (Person p : person.getMyChildren()) {
                printChildren(Name, p);
            }
        }
    }
}

