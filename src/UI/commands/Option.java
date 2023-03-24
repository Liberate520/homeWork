package Homework25_2.UI.commands;

import java.io.IOException;

public interface Option {
    String descriptions();
    void execute() throws IOException, ClassNotFoundException;
    
}
