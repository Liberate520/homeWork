package model;

import model.converter.BinaryConverter;
import model.converter.Converter;
import model.family.Family;
import model.familyRecords.FamilyRecords;
import model.human.Human;
import model.member.Connection;
import model.member.Gender;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class HumanService {
    private FamilyRecords<Human> records;
    private static final String DEFAULTPATH = String.join(File.separator, Arrays.asList("data", "saved.bin"));
    private String pathToFile;
    public HumanService() {
        records = new FamilyRecords<>();
        pathToFile = DEFAULTPATH;
    }

    public List<Family<Human>> getRecords() {
        return records.getFamilies();
    }
    public Family<Human> searchFamily(String name) {
        return records.searchFamilyByName(name);
    }
    public void addFamily(String name) {
        records.addFamily(name);
    }
    private void updateLastFilePath(String path) {
        if (path != null && !path.equals(pathToFile)) pathToFile = path;
    }
    private Converter<Human> getConverter() {
        return new BinaryConverter<>(pathToFile);
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
    public List<Human> getFamilyMembers(Family<Human> family) {
        return family.getMembers();
    }
    public Gender[] getGenders() {
        return Gender.values();
    }
    public Human globalSearchHuman(String name) {
        return records.searchHumanByName(name);
    }
    public Human searchHumanInFamily(Family<Human> family, String name) {
        for (Human human : family) {
            if (human.getName().equals(name)) return human;
        }
        return null;
    }
    public void addToFamily(Human human, Family<Human> family) {
        records.addToFamily(human, family);
    }
    public Connection[] getConnections() {
        return Connection.values();
    }
    public void addConnection(Human humanFrom, Connection connection, Human humanTo) {
        records.addConnection(humanFrom, connection, humanTo);
    }

    public String getPathToFile() {
        return pathToFile;
    }
}
