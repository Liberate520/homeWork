
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service(FamilyTree<Human> familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    private void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public Human CreateHuman() {
        return familyTree.CreateHuman();
    }

    public void getHumanByName(){
        familyTree.getHumanByName();
    }

    public void addHuman(Human human) {
        familyTree.addHuman(human);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirth() {
        familyTree.sortByBirth();
    }

    public void writeInFile() throws IOException {
        fileHandler.saveFile(familyTree, "family_tree.txt");
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        setFamilyTree(fileHandler.loadFile("family_tree.txt"));
    }

    public void printChildren() {
        System.out.println("Список древа с указанием наличия (отсутствия) детей:");
        int index = 1;
        for (Human human : familyTree.getFamilyTree()) {
            if (human.getChildren().isEmpty()) {
                System.out.printf("%d)%s (%d) не имеет детей!\n ", index, human.getName(), human.getBirthYear());
                System.out.println();
            } else {
                System.out.printf("%d)%s (%d) имеет следующих детей:\n   %s\n", 
                index++, human.getName(), human.getBirthYear(), human.getChildren());
                System.out.println();
            }
        }
    }

    public void print() {
        while (familyTree.hasNext()) {
            System.out.println(familyTree.next().toString());
        }
    }


    public void createTree() {
        Human human1 = new Human(1, "Oleg", Gender.Male, 1951);
        Human human2 = new Human(2, "Olga", Gender.Female, 1956);
        Human human3 = new Human(3, "Petia", Gender.Male, human1, human2, 1978);
        Human human4 = new Human(4, "Sveta", Gender.Female, human1, human2,1981);
        Human human5 = new Human(5, "Ilia", Gender.Male,1979);
        Human human6 = new Human(6, "Kristina", Gender.Male, human5, human4, 2000);
        Human human7 = new Human(7, "George", Gender.Male,2002);
        Human human8 = new Human(8, "Ruslan", Gender.Male, human7, human6, 2023);
        List<Human> humans = new ArrayList<>(Arrays.asList(human1, human2, human3, human4, human5, human6, human7, human8));

        for (Human human : humans) {
            familyTree.getFamilyTree().add(human);
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
        }
    }
}
