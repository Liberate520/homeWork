package FileWork;

import Group.Groupable;

public interface Writeable<T> {
    void saveToFile(Groupable<T> groupList, String filename);
    Groupable<T> LoadFromFile(String filename);
    }     
