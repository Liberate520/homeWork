package Homeworks.OOPHW.OOP_homeWork_L5.src.View;

import java.util.Scanner;

import Homeworks.OOPHW.OOP_homeWork_L5.src.Presenter.Presenter;

public class Commands {
    final private String allNotes = "Вывести все заметки";
    final private String addNote = "Добавить заметку";
    final private String exit = "Выход";

    public String getAllNotes() {
        return allNotes;
    }

    public String getAddNote() {
        return addNote;
    }

    public String getExit() {
        return exit;
    }

    public void exec(String choice,  Presenter presenter) {
        if (choice == allNotes) System.out.println(presenter.loadNotepad());
        switch (choice) {
            case (allNotes):
                System.out.println(presenter.loadNotepad());
                break;
            case (addNote):
                Scanner sc = new Scanner(System.in, "Cp866");
                System.out.println("Введите заголовок заметки => ");
                String intitle = sc.nextLine();
                System.out.println("Введите текст заметки => ");
                String intext = sc.nextLine();
                presenter.addNoteToNotepad(intitle, intext);
                break;
            case (exit):
                System.out.println("Выход из блокнота.");
                System.out.println();
                break;
            default:
                System.out.println("Что-то пошло не так...");
                break;
        }
    }
}
