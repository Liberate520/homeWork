package Interfaces;

import java.util.Scanner;

import Class.Utils;

public interface ICommands {

    //Информация о команде
    String info();
    //Код команды при вводе с клавиатуры
    String getName();
    //Выполняемый метод
    void task(Scanner scanner, Utils utils);
}
