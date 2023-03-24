package ui;

import menu.*;

import java.util.List;

public interface  OptionMenu {

    void execute(int num);
    String printMenu();
    List<Option> getCommands() ;
}
