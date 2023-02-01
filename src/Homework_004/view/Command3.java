package Homework_004.view;

import Homework_004.controller.Controller;

public class Command3 implements CommandOption {
    
    @Override
    public String discription() {
        return "Сортировка дерева по ID";
    }

    @Override
    public void exec(Controller controller) {
        controller.execCommand3(); 
    }
}
