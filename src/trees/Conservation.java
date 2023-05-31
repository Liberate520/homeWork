package trees;

public interface Conservation {
    void saveFile(FamilyTree tree);

    FamilyTree loadFile();
}