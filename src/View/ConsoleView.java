package Homeworks.OOPHW.OOP_homeWork_L5.src.View;

import java.util.Scanner;

import Homeworks.OOPHW.OOP_homeWork_L5.src.Model.Note;
import Homeworks.OOPHW.OOP_homeWork_L5.src.Presenter.Presenter;

public class ConsoleView implements View {

    @Override
    public void start() {
        Scanner scan = new Scanner (System.in, "Cp866");
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, "Homeworks/OOPHW/OOP_homeWork_L5/src/Notepad.txt");
        // Homeworks\OOPHW\OOP_homeWork_L5\src\Notepad.txt
        System.out.println("Начало работы с блокнотом.");
        int point = 0;
        while (point != 3) {
            System.out.println("Выбрите действие:\n1.Список всех записей блокнота\n" + 
                        "2.Добавить запись в блокнот\n" + "3.Выход");
            point = scan.nextInt();
            switch (point) {
                case (1):
                    System.out.println(presenter.loadNotepad());
                    break;
                case (2):
                    System.out.println("Введите заголовок заметки => ");
                    String intitle = scan.nextLine();
                    intitle = scan.nextLine();
                    System.out.println("Введите текст заметки => ");
                    String intext = scan.nextLine();
                    presenter.addNoteToNotepad(intitle, intext);
                    break;
                default:
                    if (point == 3) System.out.println("Выход из блокнота.");
                    else System.out.println("Выбор некорректен. Попробуйте ещё раз!");
                    break;
            }
        }
        System.out.println("Завершение работы.");
        scan.close();
    }
    
    @Override
    public void printAddNote(String noteTitle, String noteText) {
        Note nnote = new Note(noteTitle, noteText);
        System.out.println("Добавлена новая заметка\n" + nnote.toString());
    }
}
