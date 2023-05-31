package convertible;

import familyRecords.FamilyRecords;

import java.io.*;
import java.util.Arrays;

public class CSVConverter implements Convertible{
    private final String path;
    private final static String defaultPath = String.join(File.separator, Arrays.asList("data", "saved.bin"));
    private boolean convertSuccess;
    private String convertStatus;

    public CSVConverter(String path) {
        convertSuccess = false;
        convertStatus = "Not requested";
        this.path = path;
    }
    public CSVConverter() {
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
        convertSuccess = false;
        convertStatus = "Not implemented";
    }

    @Override
    public FamilyRecords load() {
        convertSuccess = false;
        convertStatus = "Not implemented";
        return null;
    }
}
