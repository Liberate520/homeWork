package MyNote.UI;

import java.util.Scanner;

import MyNote.Notebook;
import MyNote.Record;

public class ConsoleView implements View {

    private Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getText() {
        System.out.printf("текст: ");
        return in.nextLine();
    }

    @Override
    public void printText(String value) {
        System.out.printf("текст: %s\n", value);

    }

    @Override
    public void showRecordAdded() {
        System.out.println("Запись добавлена");
    }

    @Override
    public int getIndex() {
        System.out.println("Введите индекс записи, которую хотите удалить: ");
        int index = in.nextInt();
        return index;
    }

    @Override
    public void printNoteBook(Notebook records) {
        for (Record record : records.getNotes()) {
            System.out.println(record);
        }
    }

    public void showNoRecords() {
        System.out.println("запись удалена" + "\n");
    }

    @Override
    public void noRecods() {
        System.out.println("Записей нет");
    }

}