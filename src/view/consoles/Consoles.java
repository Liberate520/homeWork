package view.consoles;

import java.util.Scanner;

import view.ConsoleUI;

abstract class Consoles implements Iconsole {
    Scanner scanner;
    ConsoleUI cons;

    public abstract void workConsole();
}

