package Controller;

import Model.Model;
import View.View;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;        
    }

    public void onClick_1() {
        model.print();
    }

    public void onClick_2() {
        model.printFirst();
    }

    public void onClick_3() {
        model.printLast();
    }
}
