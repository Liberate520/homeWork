package model;

import presenter.PresenterNotepad;
import view.ViewNotepad;
import javax.swing.plaf.ViewportUI;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModelNotepad {
    private String writingText;
    private Scanner scanner;
    private StringBuilder stringBuilder;
    private PresenterNotepad presenterNotepad;
    private ViewNotepad viewNotepad;

    public ModelNotepad() throws IOException {
        scanner = new Scanner(System.in);
        this.stringBuilder = new StringBuilder();
        readFile();
    }
    public void setPresenter(PresenterNotepad presenterNotepad){
        this.presenterNotepad = presenterNotepad;
    }

    public void record() throws IOException {
        System.out.println("Введите свои заметки:");
        writingText = scanner.nextLine();
        stringBuilder.append(writingText + "\n");
        recordFile(writingText);
    }

    private void recordFile(String writingText) throws IOException {
        FileWriter filewriter = new FileWriter("C:\\Users\\kitti\\OneDrive\\Рабочий стол\\разработчик\\Java\\OOP\\seminar\\seminar6\\notepad\\src\\notepad.txt",true);
        filewriter.write(writingText + "\n");
        filewriter.close();
    }

    public void readFile() throws IOException {
        FileReader filereader = new FileReader("C:\\Users\\kitti\\OneDrive\\Рабочий стол\\разработчик\\Java\\OOP\\seminar\\seminar6\\notepad\\src\\notepad.txt");
        Scanner scanner = new Scanner(filereader);
        int i = 1;
        while (scanner.hasNextLine()){
            System.out.printf("%d. "+ scanner.nextLine(),i);
            System.out.println("\n");
            i++;
        }
        filereader.close();
    }

}
