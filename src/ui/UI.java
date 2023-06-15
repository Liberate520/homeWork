package ui;

public interface UI {
    void print(String text);
    void start();
    void finish();
    String noData();
    void showFamilyTrees();
    void listFamilies();
    void addFamily();
    void gotoFamily();
    void saveToFile();
    void loadFromFile();
    void showPeopleFromFamily(String familyID);
    void addHumanToFamily(String familyID);
    void addConnection(String familyID);
}
