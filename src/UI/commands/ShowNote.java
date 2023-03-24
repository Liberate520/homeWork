package Homework25_2.UI.commands;

import java.io.IOException;

import Homework25_2.UI.Console;

public class ShowNote extends Command{

    public ShowNote(Console console) {
        super(console);
    }

    @Override
    public String descriptions() {
        return "Показать все заметки";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsole();
        // printAll(null);
    }
    
}
