import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;
    private NewHuman NewHuman;
    private FindHuman findHuman;

    public Service(FamilyTree<Human> familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
        this.NewHuman = new NewHuman(familyTree);
        this.findHuman = new FindHuman(familyTree);
    }

    private void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public Human CreateHuman() {
        return NewHuman.CreateHuman();
    }

    public void getHumanByName(){
        findHuman.getHumanByName();
    }

   public void addHuman(Human human) {
        familyTree.addHuman(human);
    }

    public void writeInFile() throws IOException {
        fileHandler.saveFile(familyTree, "family_tree.txt");
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        setFamilyTree(fileHandler.loadFile("family_tree.txt"));
    }

    public void sortByParameter(int sortNumber){
        familyTree.sortByParameter(sortNumber);
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

    public void printInvitationForUser() {
        System.out.println();
        System.out.println("Введите соответствующую цифру:\n" +
        " 1 - для печати полного списка древа с указанием детей\n" +
        " 2 - для записи и сохранения в файл списка родственников древа \n" +
        " 3 - для чтения и вывода списка родственников из файла \n" +
        " 4 - для сортировки списка родственников по выбранному параметру \n" +
        " 5 - для ввода данных и добавления родственника в список древа \n" +
        " 6 - для поиска в древе родственника по имени \n" +
        " 0 - для завершения работы \n");
    }
}