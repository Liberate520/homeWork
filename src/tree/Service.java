package tree;

import human.Gender;
import serializer.Serializer;
import human.Human;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service implements Serializable {

    private FamilyTree<Human> familyTree;
    private Serializer serializ;
    private List<FamilyTree<Human>> familyTreeList;
    public int id;
    private final String filePath = "tree.dat";

    public Service(Serializer serializ) {
        this.familyTree = new FamilyTree<>();
        this.serializ = serializ;
    }


    public Service(FamilyTree<Human> tree) {
        this.familyTree = tree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(tree);

    }
    public Service(){
        this(new FamilyTree<Human>());
    }


    public void addFamilyTree(FamilyTree<Human> familyTree){
        familyTreeList.add(familyTree);
    }

    public void addHuman(String firstName, String lastname, Gender gender, LocalDate birthDate) {
        familyTree.add(new Human(firstName, lastname, gender, birthDate, null, null, null));
    }

    public String getInfoHuman() {
        StringBuilder sb = new StringBuilder();
        for (Human human : familyTree) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getTree() {
        return familyTree.toString();
    }

    public void sortByFirstName() {
        familyTree.sortByFirstName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void setWritable(Serializer writable) {
        this.serializ = writable;
    }

    public void save() {
        serializ.save(familyTree,filePath);
    }

    public Service load() {
        if (serializ != null) {
            if (serializ instanceof Service) {
                if (serializ.load(filePath) == null) {
                    System.out.println("Дерева в файле нет! Создаём новое дерево.");
                    return new Service(serializ);
                } else {
                    System.out.println("Дерево загружено из файла.");
                    return (Service) serializ.load(filePath);
                }
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
        return null;
    }
}
