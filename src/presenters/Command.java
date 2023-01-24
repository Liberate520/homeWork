package presenters;

public interface Command {
    void createNewTree();
    void createTreeFromFile();
    void addHuman();
    void deleteHuman();
    void outoutHumanByUuid();
    void deleteChildToHuman();
    void findByFIO();
    void outputEntireTree();
    void writeTreeToFile();
}
