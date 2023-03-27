package model;

import model.fileUtils.FileWorker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, отвечающий за работу с блокнотом
 */
public class Notepad {
    private List<Note> notes;
    private int hash;
    private FileWorker fileWorker;

    public void open(String folderPath, String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        this.fileWorker = new FileWorker(folderPath, fileName);
        List<String> data = fileWorker.read();
        this.notes = new ArrayList<>();

        for (String noteText : data) {
            this.notes.add(new Note(noteText));
        }

        this.hash = notes.hashCode();
    }

    public boolean isOpened() {
        return (notes != null);
    }

    public void create(String folderPath, String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        this.fileWorker = new FileWorker(folderPath, fileName);

        fileWorker.create(folderPath, fileName);
    }

    public String getNotepadName() throws IOException {
        if (isOpened()) return fileWorker.getFileName();
        else throw new IOException("ОШИБКА: невозможно получить имя файла, файл не открыт.");
    }

    public void save() throws IOException {
        List<String> buffer = new ArrayList<>();

        for (Note note : notes) {
            buffer.add(note.getContent());
        }

        fileWorker.write(buffer);
        this.hash = notes.hashCode();
    }

    public void add(Note note) throws IOException {
        if (!isOpened()) throw new IOException("ОШИБКА: Невозможно добавить запись, записная книга не открыта.");
        else {
            notes.add(note);
        }
    }

    public void remove(int index) throws IOException {
        if (!isOpened()) throw new IOException("ОШИБКА: Невозможно удалить запись, записная книга не открыта.");
        else {
            notes.remove(index);
        }
    }

    public void remove(Note note) throws IOException{
        if (!isOpened()) throw new IOException("ОШИБКА: Невозможно удалить запись, записная книга не открыта.");
        else {
            notes.remove(note);
        }
    }

    public void replace(int index, String text) throws IOException {

        if (!isOpened()) throw new IOException("ОШИБКА: Невозможно заменить запись, записная книга не открыта.");
        else {
            notes.get(index).setContent(text);
        }
    }

    public List<Note> getAllNotes() throws NullPointerException {
        if (notes != null){
            return new ArrayList<>(notes);
        } else {
            throw new NullPointerException("ОШИБКА: нельзя получить все записи, файл не открыт.");
        }
    }

    public boolean isUnsaved() {
        return hash != notes.hashCode();
    }

    public void reset(){
        this.notes = null;
        this.fileWorker = null;
        this.hash = 0;
    }
}
