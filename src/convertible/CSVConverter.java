package convertible;

import familyRecords.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

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

    private Calendar stringTDate(String str) {
        if (str.isEmpty() || str.equals("null")) return null;
        String[] dateParts = str.split("-");
        return new GregorianCalendar(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
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
        // TODO simplify this
        FamilyRecords records = new FamilyRecords();
        Map<Human, List<String>> humanConnections = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                String[] elements = line.split(Pattern.quote(csvDelimiter));
                String fullName = elements[0];
                Gender gender = Gender.fromString(elements[1]);
                Calendar birthDate = stringTDate(elements[2]);
                Calendar deathDate = stringTDate(elements[3]);
                String[] families = elements[4].split(",");
                Human human = new Human(fullName, gender, birthDate, deathDate);
                for (String familyName:families) {
                    records.addFamily(familyName, human);
                }
                List<String> connectedNames = Arrays.asList(elements[5],elements[6],elements[7],elements[8]);
                humanConnections.put(human, connectedNames);
//                for (String el:elements) System.out.println(el);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            convertSuccess = false;
            convertStatus = "Failed: " + e.getLocalizedMessage();
        }
        for (Map.Entry<Human, List<String>> entry : humanConnections.entrySet()) {
            Human human = entry.getKey();
            for (int i=0;i<FamilyConnection.values().length;i++) {
                FamilyConnection connection = FamilyConnection.values()[i];
                String connectedHumanNames = entry.getValue().get(i);
                for (String humanName:connectedHumanNames.split(",")) {
                    if (!humanName.equals("null")) records.addConnection(human, connection, records.searchHumanByName(humanName));
                }
            }
        }
        convertSuccess = true;
        convertStatus = "Done";
        return records;
    }
}
