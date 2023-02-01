package Homework_006.view;

import Homework_006.controller.Controller;

public class CommandSortById implements CommandOption {
    
    @Override
    public String discription() {
        return "Сортировка дерева по ID";
    }

    @Override
    public void exec(Controller controller) {
        controller.execSortById(); 
    }
}
