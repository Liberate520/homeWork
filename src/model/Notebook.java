package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Notebook implements FileOperations {
    private List<Record> list;
    private String path;

    public Notebook(String path) {
        this.list = new ArrayList<>();
        this.path = path;
    }

    @Override
    public void load() {
        this.list.clear();
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String rec = reader.readLine();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            while (rec != null) {
                this.list.add(gson.fromJson(rec, Task.class));
                rec = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        if (this.list.size() == 0) return;
        try (FileWriter writer = new FileWriter(path, false)) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            for (Record rec : this.list) {
                writer.append(gson.toJson(rec));
                writer.append("\n");
            }
            writer.flush();
            //writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Record> getAll() {
        return this.list;
    }

    public void addRec(String[] args) {
        this.list.add(new Task(args[0], args[1]));
    }

    public void delRec(String idx) {
        try {
            int index = Integer.parseInt(idx);
            if (index > 0 && index <= this.list.size())
                this.list.remove(index-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.list.size() == 0)
            return sb.append("список пуст").toString();
        sb.append("---- список записей ----\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.format("> %d ", i+1));
            sb.append(list.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
