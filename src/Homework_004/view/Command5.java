package Homework_004.view;

import java.io.IOException;

import Homework_004.controller.Controller;

public class Command5 implements CommandOption {
    
    @Override
    public String discription() {
        return "Сохранить дерево";
    }

    @Override
    public void exec(Controller controller) throws ClassNotFoundException, IOException {
        controller.execCommand5();
        System.out.println("Дерево сохранено"); 
    }
}
