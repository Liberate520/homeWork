package Notebook.Core.MVP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarException;
import Notebook.Core.Infrastructure.Notebook;
import Notebook.Core.Models.Recording;

public class Model implements Iterable<Recording> {
    
    Notebook NB;
    private int size;
    private String path;

    public Model(String path) {
        NB = new Notebook();
        this.path = path;
        this.size = size;
    }

    public void append(String title, String text) {
        NB.add(new Recording(title, text));
        size++;   
    }

    public void showAll() {
        int i = 1;
        for (Recording recording : NB) {
            System.out.println("Index: " + i++);
            recording.printRecord();
        }
       
    }

    public void load() throws JarException {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(path);

        try {
            List<String> list = Files.readAllLines(Paths.get(pathFile));
            for (String string : list) {
                string = (string.replace("{", "")
                        .replace("}", "")
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "")
                        .replace("\"", ""))
                        .trim();
                String[] temp = string.split(":");
                this.NB.add(new Recording(temp[0], temp[1]));                
            }
        } catch (Exception e) {
            // e.printStackTrace();
        } finally {
        }
        
    }

    public Iterator<Recording> iterator() {    

        Iterator<Recording> it = new Iterator<Recording>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i < NB.size();
            }

            @Override
            public Recording next() {
                return NB.get(i++);
            }
        };
        return it;
    }

    public Recording get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("The index is invalid!");
            return null;
        }
        return NB.get(index);
    }

    public void remove(int index) {
        NB.remove(index);         
    }

    public void set(int index, Recording rec){
        NB.set(index, rec);
    }

    void save() throws JarException {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(path);
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file);
            Iterator<Recording> iterator = NB.iterator();
            fileWriter.write("[");
            while (iterator.hasNext()) {
                Recording recording = iterator.next();
                String a = "{\"" + recording.getTitle() + "\":\"" + recording.getRecording() + "\"}";
                fileWriter.write(a);
                if (iterator.hasNext()) {
                    fileWriter.write(",\n");
                }
            }
            fileWriter.write("]");
            fileWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            NB.printArr();
        }
    }
    
}
