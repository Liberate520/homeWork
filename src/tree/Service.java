package tree;
import human.Human;
import serializer.TreeSerializer;
import ui.View;

public class Service{
    private View view;
    public FamilyTree<Human> familyTree;
    private FamilyTrees familytrees;
    private TreeSerializer serializ;
    private String filePath = "FamilyTree.bin";

    public Service(){
        serializ = new TreeSerializer(filePath);
        familytrees = new FamilyTrees();
        familyTree = familytrees.tree1();
    }

    public String getInfoHuman() {
        StringBuilder sb = new StringBuilder();
        for (Human human : familyTree) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void saveFile() {
        this.serializ.setFilePath(filePath);
        serializ.save(familyTree, filePath);
    }

    public void loadFile(String filePath) {
        this.filePath = filePath;
        this.serializ.setFilePath(filePath);
        this.familyTree = serializ.load(filePath);
    }

    public void sortTree(String choice) {
        switch (choice) {
            case "1" -> familyTree.sortByFirstName();
            case "2" -> familyTree.sortByAge();
            default -> System.out.println("Ошибка ввода");
        }
    }
}
