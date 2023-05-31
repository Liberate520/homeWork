package convertible;

import familyRecords.Family;
import familyRecords.FamilyConnection;
import familyRecords.FamilyRecords;
import familyRecords.Human;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CSVConverter implements Convertible{
    private final String path;
    private final String csvDelimiter;
    public final static String defaultPath = String.join(File.separator, Arrays.asList("data", "saved.csv"));
    public final static String  defaultDelimiter = ";";
    private boolean convertSuccess;
    private String convertStatus;

    public CSVConverter(String path, String cdvDelimiter) {
        convertSuccess = false;
        convertStatus = "Not requested";
        this.path = path;
        this.csvDelimiter = cdvDelimiter;
    }
    public CSVConverter() {
        this(defaultPath, defaultDelimiter);
    }

    public boolean convertSuccess(){
        return convertSuccess;
    }
    public String convertStatus(){
        return convertStatus;
    }

    private String dateToString(Calendar date) {
        if (date == null) return "null";
        return String.format("%d-%d-%d", date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.MONTH), date.get(Calendar.YEAR));
    }
    private String familiesNames(Set<Family> families) {
        if (families == null || families.isEmpty()) return "null";
        List<String> names = new ArrayList<>();
        for (Family family:families) {
            names.add(family.getName());
        }
        return String.join(",", names);
    }

    private String connectedPeopleNames(Set<Human> relatedMembers) {
        if (relatedMembers == null || relatedMembers.isEmpty()) return "null";
        List<String> names = new ArrayList<>();
        for (Human human:relatedMembers) {
            names.add(human.getName());
        }
        return String.join(",", names);
    }

    @Override
    public void save(FamilyRecords records){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), StandardCharsets.UTF_8))) {
            convertStatus = "In progress";
            for (Human human:records.getPeople()) {
                List<String> humanStrings = new ArrayList<>();
                humanStrings.add(human.getName());
                humanStrings.add(human.getGender().toString());
                humanStrings.add(dateToString(human.getBirthDate()));
                humanStrings.add(dateToString(human.getDeathDate()));
                humanStrings.add(familiesNames(human.getFamilies()));
                for (FamilyConnection connection:FamilyConnection.values()) {
                    humanStrings.add(connectedPeopleNames(human.getRelatedMembers(connection)));
                }
                writer.write(String.join(csvDelimiter, humanStrings));
                writer.write("\n");
            }
            writer.close();
            convertStatus = "Done";
            convertSuccess = true;
        } catch (IOException e) {
            convertStatus = "Failed: " + e.getLocalizedMessage();
            convertSuccess = false;
        }

    }

    @Override
    public FamilyRecords load() {
        convertSuccess = false;
        convertStatus = "Not implemented";
        return null;
    }
}
