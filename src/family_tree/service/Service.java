package family_tree.service;

import family_tree.FamilyTree;
import family_tree.Gender;
import family_tree.Human;
import family_tree.writer.FileHandler;

import java.io.File;
import java.time.LocalDate;

public class Service {
    private FamilyTree tree;

    public Service() {
        tree = new FamilyTree();
    }

    public String printFamilyTree(){
        return tree.getData();
    }

    public void addHuman(String name,Gender gender, LocalDate birth, LocalDate death, Object parentM, Object parentF){
        Human human = new Human<>(name,gender, birth,death,null,null);
        tree.add(human);
        System.out.println("\nНовый член семейного дерева успешно добавлен.\n");
    }
    public void sortByName(){
        tree.sortByName();
        System.out.println("Выполнена сортировка по имени.\n");
    }

    public void sortByAge(){
        tree.sortByAge();
        System.out.println("Выполнена сортировка по возрасту.\n");
    }

        public static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.isFile();
    }

    public FamilyTree loadFamilyTree() {
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_tree/writer/tree.txt";
        if (isFileExists(filePath)) {
            return tree = (FamilyTree) fileHandler.read(filePath);
        } else {
            System.out.println("Файл не найден.\n");
            return null;
        }
    }

    public void saveFamilyTree() {
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_tree/writer/tree.txt";
        fileHandler.save(tree,filePath);
        System.out.println("Файл успешно записан.\n");
    }

    public void addParentGlobal(long human_id, long parent_id) {
        Human human = (Human) tree.getById(human_id);
        Human parent = (Human) tree.getById(parent_id);
        human.addParent(tree.getById(parent_id));
        parent.addKid(tree.getById(human_id));
        System.out.println("Родитель успешно добавлен.\n");
    }

}
