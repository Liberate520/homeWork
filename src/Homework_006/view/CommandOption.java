package Homework_006.view;

import java.io.IOException;

import Homework_006.controller.Controller;

public interface CommandOption {
    String discription();
    void exec(Controller controller) throws ClassNotFoundException, IOException;
}
