package model.workingWithFile;

import model.tree.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileData<E> implements WorkingFile {

    private Path file;
    public ArrayList<String> contents = new ArrayList<>();
    private String template;


    public FileData(String filePath, String template) {

        this.template = template;
        load(filePath);

    }

    public FileData() {
        this.contents = new ArrayList<>();

    }


    public void load(String filePath) {
        try {
            this.file = Paths.get(filePath);
            this.contents = (ArrayList<String>) Files.readAllLines(file);
        } catch (IOException e) {
            this.contents.add("Файл отсутствует или имеет некорректный формат");
        }
    }




    public void adding(Node n, String file) {
        String data = n.toFileString();
        this.contents.add(data);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(data);
    }


}










