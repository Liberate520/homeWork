package Homework25_2.UI.commands;

import java.io.IOException;

import Homework25_2.UI.Console;

public class Exit extends Command {

    public Exit(Console console) {
        super(console);
    }

    @Override
    public String descriptions() {
        return "Выход";
    }


    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsole();
    }
    
}
