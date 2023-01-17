package Homework_004.view;

import Homework_004.controller.Controller;

public class Command4 implements CommandOption {
    
    @Override
    public String discription() {
        return "Сортировка дерева по дате рождения";
    }

    @Override
    public void exec(Controller controller) {
        controller.execCommand4(); 
    }
}
