package main;

import UI.*;
import presenter.Presenter;

public class Program {
    public static void main(String[] args) {
        View view = new Console();
        Service service = new TreeService();
        new Presenter(view, service);
        view.start();
    }
}