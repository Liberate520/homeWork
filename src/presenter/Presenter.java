package presenter;

import model.HumanService;
import ui.UI;
import java.util.List;

public class Presenter {
    private UI view;
    private HumanService model;

    public Presenter(UI view) {
        this.view = view;
        model = new HumanService();
    }

    private List<String> getFamilyMemberIDs(String familyID){
        return model.getFamilyMemberIDs(familyID);
    }

    private String getFamilyString(String familyId){
        return model.getFamilyName(familyId);
    }
    private String getHumanString(String familyId, String humanID){
        return model.getHumanInfo(familyId, humanID);
    }

    public void showFamilyTreeStr() {
        List<String> familiesIDs = model.getFamiliesIDs();
        if (familiesIDs == null || familiesIDs.size() == 0) view.print(view.noData());
        else {
            StringBuilder result = new StringBuilder();
            for (String familyID : familiesIDs) {
                result.append("Семья '").append(getFamilyString(familyID)).append("':\n");
                List<String> familyMemberIDs = getFamilyMemberIDs(familyID);
                if (familyMemberIDs == null || familyMemberIDs.size() == 0){
                    result.append("\t").append(view.noData()).append("\n");
                } else {
                    for (String humanID : familyMemberIDs) {
                        result.append("\t").append(getHumanString(familyID, humanID)).append("\n");
                    }
                }
            }
            view.print(result.toString());
        }
    }

    public void listFamilies() {
        List<String> familiesIDs = model.getFamiliesIDs();
        if (familiesIDs == null || familiesIDs.size() == 0) view.print(view.noData());
        else {
            StringBuilder result = new StringBuilder();
            for (String familyID : familiesIDs) {
                result.append(getFamilyString(familyID)).append("\n");
            }
            view.print(result.toString());
        }
    }

    public boolean addFamily(String name) {
        return model.addFamily(name);
    }

    public String searchFamily(String name) {
        return model.searchFamily(name);
    }

    public boolean saveToFile(String path) {
        return model.save(path);
    }
    public boolean loadFromFile(String path) {
        return model.load(path);
    }

    public String getLastFilepath() {
        return model.getPathToFile();
    }

    public void showPeopleFromFamily(String familyID) {
        StringBuilder result = new StringBuilder();
        List<String> familyMemberIDs = getFamilyMemberIDs(familyID);
        if (familyMemberIDs == null || familyMemberIDs.size() == 0){
            result.append(view.noData()).append("\n");
        } else {
            for (String humanID : familyMemberIDs) {
                result.append(getHumanString(familyID, humanID)).append("\n");
            }
        }
        view.print(result.toString());
    }

    public List<String> getGenderNames() {
        return model.getGenderNames();
    }

    public boolean addHuman(String familyID, String name, String genderName, String birthDateString, String deathDateString) {
        return model.addHuman(familyID, name, genderName, birthDateString, deathDateString);
    }

    public String searchHumanInFamily(String familyId, String name) {
        return model.searchHuman(familyId, name);
    }

    public String searchHuman(String name) {
        return model.searchHuman(name);
    }

    public List<String> getConnectionNames() {
        return model.getConnectionNames();
    }

    public boolean addConnection(String firstHumanID, String connectionName, String secondHumanID) {
        return model.addConnection(firstHumanID, connectionName, secondHumanID);
    }

    public String getCurrentFileFormat() {
        return model.getCurrentFileFormat();
    }
    public List<String> getFileFormats() {
        return model.getFileFormats();
    }
    public void setFileFormat(String newFormat) {
        model.setFileFormat(newFormat);
    }
}
