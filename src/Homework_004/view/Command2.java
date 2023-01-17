package Homework_004.view;

import Homework_004.controller.Controller;

public class Command2 implements CommandOption {
    
    @Override
    public String discription() {
        return "Просмотр дерева";
    }

    @Override
    public void exec(Controller controller) {
        controller.execCommand2(); 
    }
}
