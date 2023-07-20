package familytree.model;

public interface IOFile {

/*    void fileOutput() throws IOException, ClassNotFoundException;

    void fileInput()throws IOException, ClassNotFoundException;*/

    void saveFamilyTree(Familytree familyTree, String fileName);
    Familytree loadFamilyTree(String fileName);

}
