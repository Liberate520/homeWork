package presenters;

public interface Command {
    void createNewTree();
    void createTreeFromFile();
    void addHuman();
    void addMotherToHuman();
    void addFatherToHuman();
    void addSpouseToHuman();
    void deleteHuman();
    void outoutHumanByUuid();
    void deleteChildToHuman();
    void findByFIO();
    void outputEntireTree();
    void establishKinshipRelationship();
    void writeTreeToFile();
}
