package Model;

public interface Operation {
    void printConsole();
    void printFile();
    void sortHumanByBirth();
    void sortHumanByName();
    void printHuman(int order);
    void printHumanChild(int order);
    void printHumanSistBroth(int order);
    void printHumanFather(int order);
    void printHumanMother(int order);
    boolean orderCheck(int order);
}
