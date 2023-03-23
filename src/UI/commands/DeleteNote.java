package Homework25_2.UI.commands;

import java.io.IOException;

import Homework25_2.UI.Console;

public class DeleteNote extends Command{

    public DeleteNote(Console console) {
        super(console);
    }

    @Override
    public String descriptions() {
        return "Удалить заметку";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsole();
    }
    
}
