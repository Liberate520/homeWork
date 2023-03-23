package model;

import java.io.*;
import java.util.Scanner;


public class Service implements FileData {
    private Notepad notepad = new Notepad();
    private Scanner scanner = new Scanner(System.in);

    public String myNotes(){
        String comment;
        notepad.addNotes(new Notepad("Сегодня сделать ужин - картошку с курицей"));
        notepad.addNotes(new Notepad("Записаться в Молодежный центр для сертификата"));
        notepad.addNotes(new Notepad("Сделать на работе 5 договоров на строительный контроль"));
        notepad.addNotes(new Notepad("Купить что-нибудь вкусненькое"));
        notepad.addNotes(new Notepad("Уйти уже в отпуск"));
        return comment = "Мои записи ";
    }

    public String loadData () throws IOException, ClassNotFoundException {
        String comment;
        notepad = (Notepad)read("notepad.out");
        return comment = "Блокнот загружен";
    }
    public String saveData() throws Exception {
        String comment;
        save((Serializable) notepad, "notepad.out");
        return comment = "Блокнот сохранен";
    }
    public String addNotes(String notes){
        String comment;
        notepad.addNotes(new Notepad(notes));
        return  comment = "Запись в блокноте создана";
    }
    public String searchNote(String noteForSearch){
        return notepad.getNotes(noteForSearch).toString();
    }
    public String printNotes(){
        StringBuilder stringBuilder=new StringBuilder();
        for (Object note: notepad) stringBuilder.append(note.toString());
        return stringBuilder.toString();
    }
    public String deleteNotes(int number){
        String comment;
        notepad.getDeleteNotes(number);
        return  comment = "Запись в блокноте удалена";
    }


    @Override
    public void save(Serializable serializable, String filename) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object read(String filename) throws IOException, ClassNotFoundException {
        Object result = new Object();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}
