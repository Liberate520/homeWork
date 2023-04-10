package fileWork;
import group.Groupable;

public interface Writeable<T> {
    void SaveToFile(Groupable<T> groupList, String filename);
    Groupable<T> LoadFromFile(String filename);
    }   

