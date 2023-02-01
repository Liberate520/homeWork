package Homework_004.view;

import Homework_004.controller.Controller;

public class CommandExit implements CommandOption {
    
    @Override
    public String discription() {
        return "Выход";
    }

    @Override
    public void exec(Controller controller) {
        controller.execCommandExit();
    }
}
