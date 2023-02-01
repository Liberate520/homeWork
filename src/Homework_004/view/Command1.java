package Homework_004.view;

import java.io.IOException;

import Homework_004.controller.Controller;

public class Command1 implements CommandOption {
    
    @Override
    public String discription() {
        return "Загрузка дерева";
    }

    @Override
    public void exec(Controller controller) throws ClassNotFoundException, IOException{
        controller.execCommand1(); 
        System.out.println("Дерево загружено"); 
    }
}
