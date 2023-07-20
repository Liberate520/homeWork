package org.genealogy;

import org.genealogy.view.ConsoleUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConsoleUI c = new ConsoleUI();
        c.start();
    }
}