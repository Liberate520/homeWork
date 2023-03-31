package org.example;

import mvp.Model;
import mvp.Presenter;
import mvp.View;


public class Main {
    public static void main(String[] args) {
//        BlockNote bn = new BlockNote();
//        bn.addNote("Note");
//        System.out.println(bn.toString());
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(view, model);
        view.start();
    }
}