package Homework_004.view;

import java.io.IOException;

import Homework_004.controller.Controller;

public interface CommandOption {
    String discription();
    void exec(Controller controller) throws ClassNotFoundException, IOException;
}
