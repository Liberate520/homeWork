package FileWork;

import Group.Groupable;

public interface Writeable {
    void saveToFile(Groupable groupList, String filename);
    Groupable LoadFromFile(String filename);
    }   
