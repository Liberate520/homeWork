package ui;

import model.family.Family;
import model.human.Human;

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
    void showPeopleFromFamily(Family<Human> family);
    void addHumanToFamily(Family<Human> family);
    void addConnection(Family<Human> family);
}
