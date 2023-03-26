package MyNote.UI;

import java.util.List;
import java.util.Scanner;

import MyNote.Record;

public class ConsoleView implements View{
    
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }

  

    @Override
    public String getText() {
        System.out.printf("текст: ");
        return in.nextLine();
    }

    @Override
    public void setText(String volue) {
        System.out.printf("текст: %s\n", volue);

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
    public void printNoteBook(List<Record> records) {
        for (Record record : records) {
            System.out.println(record);
        }
    }



   



  

    
  
}