package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRecorder {
    // ПОЛЯ КЛАССА
    private final String path;
    private final PlanManager plan;


    // КОНСТРУКТОР
    public FileRecorder(String path, PlanManager plan) {
        this.path = path;
        this.plan = plan;
    }

    // МЕТОДЫ КЛАССА
    public void load() {                                                                    // Добавление записи в файл.
        plan.clear();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String record = bufferedReader.readLine();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            while (record != null) {
                plan.addClass(gson.fromJson(record, Task.class));
                record = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {                                                                    // Сохранение записи.
        if (plan.getSize() == 0) return;
        try (java.io.FileWriter writer = new java.io.FileWriter(this.path, false)) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            for (Plan rec : plan.getAll()) {
                writer.append(gson.toJson(rec));
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}