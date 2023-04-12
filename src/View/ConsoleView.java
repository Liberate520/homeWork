package Homeworks.OOPHW.OOP_homeWork_L5.src.View;

import java.util.Scanner;

import Homeworks.OOPHW.OOP_homeWork_L5.src.Presenter.Presenter;

public class ConsoleView implements View {
    @Override
    public void start() {
        Scanner scan = new Scanner (System.in, "Cp866");
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, "Homeworks/OOPHW/OOP_homeWork_L5/src/Notepad.txt");
        // Homeworks\OOPHW\OOP_homeWork_L5\src\Notepad.txt
        Menu menu = new ConsoleMenu();
        System.out.println("*** Начало работы с блокнотом ******************");
        int point = 0;
        while (point != menu.sizeMenu()) {
            menu.printMenu();
            point = scan.nextInt();
            menu.perform(point, presenter);
        }
        System.out.println("*** Завершение работы с блокнотом **************");
        scan.close();
    }
    
    @Override
    public void printAddNote(String noteTitle, String noteText) {
        System.out.println("Добавлена новая заметка\n   заголовок заметки => " + noteTitle +  
                    "\n   текст заметки => " + noteText +  "\n");
    }
}
