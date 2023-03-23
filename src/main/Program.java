package main;

import UI.*;
import presenter.Presenter;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new Console();
        Service service = new TreeService();
        new Presenter(view, service);
        view.start();
    }
}