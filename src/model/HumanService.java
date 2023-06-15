package model;

import model.converter.BinaryConverter;
import model.converter.Converter;
import model.family.Family;
import model.familyRecords.FamilyRecords;
import model.human.Human;
import model.member.Connection;
import model.member.Gender;

import java.io.File;
import java.util.*;

public class HumanService {
    private FamilyRecords<Human> records;
    private static final String DEFAULTPATH = String.join(File.separator, Arrays.asList("data", "saved.bin"));
    private String pathToFile;
    public HumanService() {
        records = new FamilyRecords<>();
        pathToFile = DEFAULTPATH;
    }

    private String getFamilyID(Family<Human> family) {
        return family.getName();
    }

    private Family<Human> getFamilyFromID(String familyID) {
        return records.searchFamilyByName(familyID);
    }

    private String getHumanID(Human human) {
        return human.getName();
    }

    /**
     * @param familyID search only in this family, if set
     * @param humanID
     * @return return human or null if no such human or no such human in this family
     */
    private Human getHumanFromID(String familyID, String humanID) {
        Human human = records.searchHumanByName(humanID);
        if (familyID == null) return human;
        else {
            Family<Human> family = getFamilyFromID(familyID);
            if (human.getFamilies().contains(family)) return human;
            else return null;
        }
    }

    public String getFamilyName(String familyID){
        Family<Human> family = getFamilyFromID(familyID);
        return family.getName();
    }

    public String getHumanInfo(String familyId, String humanID) {
        Human human = getHumanFromID(familyId, humanID);
        return (human != null) ? human.toString() : null;
    }

    /**
     * @return List of String familyID`s
     */
    public List<String> getFamiliesIDs() {
        List<String> result = new ArrayList<>();
        for (Family<Human> family : records) {
            result.add(getFamilyID(family));
        }
        return result;
    }

    /**
     * @param familyID
     * @return List of String familyMemberID`s
     */
    public List<String> getFamilyMemberIDs(String familyID) {
        List<String> result = new ArrayList<>();
        Family<Human> family = getFamilyFromID(familyID);
        if (family == null) return result;
        for (Human member:family) {
            result.add(member.getName());
        }
        return result;
    }

    public boolean addFamily(String name) {
        if (getFamilyFromID(name) != null) return false;
        records.addFamily(name);
        return true;
    }

    public String searchFamily(String name) {
        Family<Human> family = records.searchFamilyByName(name);
        if (family == null) return null;
        return getFamilyID(family);
    }

    private void updateLastFilePath(String path) {
        if (path != null && !path.equals(pathToFile)) pathToFile = path;
    }
    private Converter<Human> getConverter() {
        return new BinaryConverter<>(pathToFile);
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public boolean save(String path) {
        updateLastFilePath(path);
        Converter<Human> binaryConverter = getConverter();
        records.save(binaryConverter);
        // TODO binaryConverter.convertStatus() -> logs
        return binaryConverter.convertSuccess();
    }

    public boolean load(String path) {
        updateLastFilePath(path);
        Converter<Human> binaryConverter = getConverter();
        records = binaryConverter.load();
        // TODO binaryConverter.convertStatus() -> logs
        return binaryConverter.convertSuccess();
    }

    public List<String> getGenderNames() {
        List<String> result = new ArrayList<>();
        for (Gender gender : Gender.values()) {
            result.add(gender.toString());
        }
        return result;
    }

    private Calendar parseDate(String dateString) {
        if (dateString.isEmpty()) return null;
        String[] dateStrings = dateString.split("-");
        return new GregorianCalendar(Integer.parseInt(dateStrings[0]),
                Integer.parseInt(dateStrings[1]), Integer.parseInt(dateStrings[2]));
    }
    public boolean addHuman(String familyID, String name, String genderName, String birthDateString, String deathDateString) {
        Family<Human> family = getFamilyFromID(familyID);
        Human human = getHumanFromID(null, name);
        if (human != null) {
            if (getHumanFromID(familyID, name) != null) {
                return false;
//                view.print("Человек с таким именем уже есть в этой семье");
            }
            else {
                records.addToFamily(human, family);
                return true;
//                view.print("Человек с таким именем найден вне этой семьи и добавлен в состав семьи");
            }
        }
        else {
            Calendar birthDate = parseDate(birthDateString);
            Calendar deathDate = parseDate(deathDateString);
            human = new Human(name, Gender.fromString(genderName), birthDate, deathDate);
            records.addToFamily(human, family);
            return true;
//            view.print(String.format("Человек '%s' создан\n", name));
        }
    }

    /**
     * @param familyId search only in this family, if set
     * @param humanName
     * @return return humanID or null if no such human or no such human in this family
     */
    public String searchHuman(String familyId, String humanName) {
        Human human = records.searchHumanByName(humanName);
        if (human == null) return null;
        if (familyId != null) {
            Family<Human> family = getFamilyFromID(familyId);
            if (family.getMembers().contains(human)) return getHumanID(human);
            else return null;
        } else return getHumanID(human);
    }

    public String searchHuman(String humanName) {
        return searchHuman(null, humanName);
    }

    public List<String> getConnectionNames() {
        List<String> result = new ArrayList<>();
        for (Connection connection : Connection.values()) {
            result.add(connection.toString());
        }
        return result;
    }

    public boolean addConnection(String humanFromID, String connectionName, String humanToID) {
        Human humanFrom = getHumanFromID(null, humanFromID);
        Human humanTo = getHumanFromID(null, humanToID);
        if (humanFrom == null || humanTo == null) return false;
        records.addConnection(humanFrom, Connection.fromString(connectionName), humanTo);
        return true;
    }
}
