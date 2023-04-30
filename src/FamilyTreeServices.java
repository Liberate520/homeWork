import model.FileReaderWriter;
import model.familytree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.human.HumanCreator;

public class FamilyTreeServices {
    private FamilyTree<Human> familyTree;
    private FileReaderWriter fileReaderWriter;
    private HumanCreator humanCreator;

    public FamilyTreeServices() {
        this.familyTree = new FamilyTree();
        this.fileReaderWriter = new FileReaderWriter();
        this.humanCreator = new HumanCreator();
    }

    public Human createNewHuman() {
        return humanCreator.createNewHuman();
    }

    public Human createNewHuman(Gender gender, String name, String lastName, Integer age) {
        return humanCreator.createNewHuman(gender, name, lastName, age);
    }

    public FamilyTree readFamilyTreeFromFile(String path){
       return fileReaderWriter.read(path);
    }

    public void writeFamilyTreeInFile(String path) {
        fileReaderWriter.write(this.familyTree, path);
    }

    public void addHumanToFamilyTree(Human human) {
        this.familyTree.addHumanToList(human);
    }

    public void getFamilyTreeInfo() {
        for (Human human : familyTree) {
            System.out.println(human.getGeneralInfo());
        }
    }

    public void sortFamilyTreeByName() {
        this.familyTree.sortByName();
    }

    public void sortFamilyTreeByAge() {
        this.familyTree.sortByAge();
    }

    public void sortFamilyTreeById() {
        this.familyTree.sortById();
    }

    public void sortFamilyTreeByLastname() {
        this.familyTree.sortByLastname();
    }

    public void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }
}
