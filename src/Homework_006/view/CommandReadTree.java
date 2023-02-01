package Homework_006.view;

import java.io.IOException;

import Homework_006.controller.Controller;

public class CommandReadTree implements CommandOption {
    
    @Override
    public String discription() {
        return "Загрузка дерева";
    }

    @Override
    public void exec(Controller controller) throws ClassNotFoundException, IOException{
        controller.execRead(); 
    }
}
