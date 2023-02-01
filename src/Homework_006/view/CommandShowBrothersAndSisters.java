package Homework_006.view;

import Homework_006.controller.Controller;

public class CommandShowBrothersAndSisters implements CommandOption {
    
    @Override
    public String discription() {
        return "Показать братьев и сестер";
    }

    @Override
    public void exec(Controller controller) {
        controller.execShowBrothersAndSisters(controller.getView().requestNodeId()); 
    }

}