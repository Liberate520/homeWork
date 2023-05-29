package homeWork.tree2;

import tree2.FamilyTree;

public interface FileFormat {
    void saveToCSV();
    void saveToJson(String familyTree);

    void saveToDB();
}
