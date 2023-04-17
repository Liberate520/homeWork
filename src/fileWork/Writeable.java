package fileWork;

import group.Groupable;

public interface Writeable {
    void saveToFile(Groupable groupList, String filename);
    Groupable loadFromFile(String filename);
    }   
