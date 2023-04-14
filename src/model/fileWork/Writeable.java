package model.fileWork;

import model.group.Groupable;

public interface Writeable<T> {
    void SaveToFile(Groupable<T> groupList, String filename);
    Groupable<T> LoadFromFile(String filename);
    }     
