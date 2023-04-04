package fileWork;
import group.Groupable;

public interface Writeable {
    void SaveToFile(Groupable groupList, String filename);
    Groupable LoadFromFile(String filename);
    }   

