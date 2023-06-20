package model;

import model.converter.BinaryConverter;
import model.converter.Converter;
import model.converter.ConverterFactory;
import model.family.Family;
import model.familyRecords.FamilyRecords;
import model.human.Human;
import model.member.Connection;
import model.member.Gender;
import model.memberFactory.FactoryMemberProvider;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class HumanService {
    private FamilyRecords<Human> records;
    private ConverterFactory<Human> converterFactory;
    private Converter<Human> converter;
    public HumanService() {
        records = new FamilyRecords<>();
        converterFactory = new ConverterFactory<Human>(FactoryMemberProvider.getFactory("human"));
        converter = converterFactory.getConverter();
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
        if (family != null) {
            for (Human member:family) {
                result.add(member.getName());
            }
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
        if (path != null && !path.isEmpty()) converter.setPath(path);
    }

    public String getPathToFile() {
        return converter.getPath();
    }

    public boolean save(String path) {
        updateLastFilePath(path);
        records.save(converter);
        // TODO converter.convertStatus() -> logs
        return converter.convertSuccess();
    }

    public boolean load(String path) {
        updateLastFilePath(path);
        records = converter.load();
        // TODO converter.convertStatus() -> logs
        return converter.convertSuccess();
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

    private Human createHuman(String name, String genderName, String birthDateString, String deathDateString) {
        Calendar birthDate = parseDate(birthDateString);
        Calendar deathDate = parseDate(deathDateString);
        return new Human(name, Gender.fromString(genderName), birthDate, deathDate);
    }

    /**
     * Find or create Human and add it to familyId
     * @param familyID FamilyID, always assume that family with this ID exist
     * @param name
     * @param genderName
     * @param birthDateString
     * @param deathDateString
     * @return true if Human was found in other family or created. Otherwise,(human already in this family) false
     */
    public boolean addHuman(String familyID, String name, String genderName, String birthDateString, String deathDateString) {
        Family<Human> family = getFamilyFromID(familyID);
        Human human = getHumanFromID(null, name);
        if (human == null) human = createHuman(name, genderName, birthDateString, deathDateString);
        if (getHumanFromID(familyID, name) != null) {
            return false;
        }
        else {
            records.addToFamily(human, family);
            return true;
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

    public String getCurrentFileFormat() {
        return converterFactory.getConverterName(converter);
    }

    public List<String> getFileFormats() {
        return converterFactory.getConverterNames();
    }

    public void setFileFormat(String newFormat) {
        converter = converterFactory.getConverter(newFormat);
    }
}
