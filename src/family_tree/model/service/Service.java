package family_tree.model.service;

import family_tree.model.creatures.Human;
import family_tree.model.file_handler.FileHandler;
import family_tree.model.tree.FamilyTree;

import java.io.IOException;

public class Service {
    private FamilyTree<Human> tree;

    public Service(){
        tree = new FamilyTree<>();
    }

    public void loadFamilyTreeFromFile(String path) throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        tree = (FamilyTree) fileHandler.read(path);
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей в семейном древе:\n");
        for (Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String viewAllFamily(int id){
       return tree.viewAllFamily(id);
    }

    public void sortById(){
        tree.sortById();
    }

    public void sortByDateOfBirth(){
        tree.sortByDateOfBirth();
    }

    public void sortByAge(){
        tree.sortByDateOfAge();
    }
}
