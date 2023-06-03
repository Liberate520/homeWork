package converter;

import familyRecords.FamilyRecords;

import java.io.*;
import java.util.Arrays;

public class BinaryConverter implements Converter {
    private final String path;
    private final static String defaultPath = String.join(File.separator, Arrays.asList("data", "saved.bin"));
    private boolean convertSuccess;
    private String convertStatus;

    public BinaryConverter(String path) {
        convertSuccess = false;
        convertStatus = "Not requested";
        this.path = path;
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

    @Override
    public void save(FamilyRecords records){
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
    public FamilyRecords load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            convertStatus = "In progress";
            FamilyRecords data = (FamilyRecords) in.readObject();
            convertSuccess = true;
            convertStatus = "Done";
            return data;
        } catch (IOException e) {
            convertStatus = "Failed: " + e.getLocalizedMessage();
            convertSuccess = false;
        } catch (ClassNotFoundException e) {
            convertStatus = "Failed: " + e.getLocalizedMessage();
            convertSuccess = false;
        }
        return null;
    }
}
