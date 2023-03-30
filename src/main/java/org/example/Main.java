package org.example;

import mvp.Model;
import mvp.View;
import mvp.Presenter;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(view, model);
        view.start();
    }
}