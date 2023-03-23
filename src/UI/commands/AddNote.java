package Homework25_2.UI.commands;

import java.io.IOException;

import Homework25_2.UI.Console;

public class AddNote extends Command{

    public AddNote(Console console) {
        super(console);
    }

    @Override
    public String descriptions() {
        return "Добавить заметку";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsole();
    }
    
}
