package Homework_006.view;

import Homework_006.controller.Controller;

public class CommandSetParent implements CommandOption {
    
    @Override
    public String discription() {
        return "Добавить родителя";
    }

    @Override
    public void exec(Controller controller) {
        controller.execSetParent(controller.getView().setParentForm());
    }
}