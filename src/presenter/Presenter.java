package presenter;

import model.familyTrees.FamilyTree;
import model.fileManage.FileManager;
import model.members.Member;

public class Presenter<T extends Member> {
    private FamilyTree<T> familyTree;
    private FileManager fileManager;


    public void importFile(String filePath) {
        fileManager = new FileManager(filePath);
        familyTree = fileManager.loadFile();
    }

    public void saveFile() {
        fileManager.saveFile(familyTree);
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public FamilyTree<T> getFamilyTree() {
        return familyTree;
    }

    public void addRecord(String name, String dateOfBirth) {

        System.out.println("Добавление записи");

    }

    public Member getRecord(String name, String  year) {
        int num = Integer.parseInt(year);
        return familyTree.getHumanFromTree(name, num);
    }

    public void getAllRecord() {
        for (Member member : familyTree
        ) {
            System.out.println(member);
        }
    }

}
