package view;
/**
 * класс реализации интерфейса по средствам терминала
 */

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import presenter.Controller;

import java.io.IOException;
import java.util.Scanner;
public class ConsoleTerminal extends Console<Controller> implements View {
    //private Controller controller;
    private Scanner scanner;

    public ConsoleTerminal() {
        scanner = new Scanner(System.in);
        controller = super.getController();
        //scanner = new Scanner(System.in, "Cp866");
    }

    @Override
    public void start() throws JSONException, IOException, ParseException {
        super.controller.onClick();
    }

    @Override
    public String scanString(String s) {
        System.out.println(s);
        return scanner.nextLine();
    }

    @Override
    public void printStr(String s) {
        System.out.println(s);
    }
}

