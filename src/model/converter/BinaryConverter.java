package model.converter;

import model.familyRecords.FamilyRecords;
import model.member.Member;
import java.io.*;
import java.util.Arrays;

public class BinaryConverter<E extends Member> implements Converter<E> {
    private String path;
    private final static String defaultPath = String.join(File.separator, Arrays.asList("data", "saved.bin"));
    private boolean convertSuccess;
    private String convertStatus;

    public BinaryConverter(String path) {
        convertSuccess = false;
        convertStatus = "Not requested"; // TODO: probably change this to some enum of statuses
        if (path != null && !path.isEmpty()) this.path = path;
        else this.path = defaultPath;
    }
    public BinaryConverter() {
        this(defaultPath);
    }

    public boolean convertSuccess(){
        return convertSuccess;
    }
    public String convertStatus(){
        return convertStatus;
    }

    public String getPath() {
        return path;
    };
    public void setPath(String newPath) {
        if (newPath != null && !newPath.isEmpty()) path = newPath;
    }
    @Override
    public void save(FamilyRecords<E> records){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            convertStatus = "In progress";
            out.writeObject(records);
            out.close();
            convertStatus = "Done";
            convertSuccess = true;
        } catch (IOException e) {
            convertStatus = "Failed: " + e.getLocalizedMessage();
            convertSuccess = false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public FamilyRecords<E> load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            convertStatus = "In progress";
            FamilyRecords<E> data = (FamilyRecords<E>) in.readObject();
            convertSuccess = true;
            convertStatus = "Done";
            return data;
        } catch (IOException | ClassNotFoundException e) {
            convertStatus = "Failed: " + e.getLocalizedMessage();
            convertSuccess = false;
        } catch (ClassCastException e) {
            convertStatus = "Failed: loaded file contains unexpected types";
            convertSuccess = false;
        }
        return null;
    }
}
