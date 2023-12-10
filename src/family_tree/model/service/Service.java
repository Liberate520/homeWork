package family_tree.model.service;

import family_tree.model.family.FamilyTree;
import family_tree.model.family.TreeNode;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Service<T extends TreeNode<T>> {
    private FamilyTree<T> familyTree;
    private FileHandler fileHandler;

    public Service(FamilyTree<T> tree) {
        this.familyTree = tree;
        fileHandler = new FileHandler();
    }

    public Service() {
        this(null);
    }


    public String getHumanListInfo(FamilyTree<T> tree) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список членов семьи:\n");
        for (T human : tree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(FamilyTree<T> tree) {
        tree.sortByName();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge(FamilyTree<T> tree) {
        tree.sortByAge();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }


    public void addFamilyMember(String gender, String name, String familyName, String strDate) {
        Gender newGender = Gender.valueOf(gender);
        LocalDate birthDate = getLocalDate(strDate);
        Human human = new Human(newGender, name, familyName, birthDate);
        familyTree.addFamilyMember((T)human);
    }

    public LocalDate getLocalDate(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(strDate, formatter);
    }

    public String getFamilyTreeMembers() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список членов семьи:\n");
        for (T human : familyTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void saveTreeToFile() {
        String filePath = "src/family_tree/model/writer/tree";
        //FileHandler fh = new FileHandler();
        System.out.printf("Данные успешно сохранены в файл? %b\n", fileHandler.write(familyTree, filePath));
    }

    public FamilyTree<Human> getTreeFromFile() {
        String filePath = "src/family_tree/model/writer/tree";
        //FileHandler fh = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);

    }
}
