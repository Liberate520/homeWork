package family_tree.model.service;

import family_tree.model.creatures.interfaces.Creatures;
import family_tree.model.file_handler.interfaces.ReadAndWrite;
import family_tree.model.tree.FamilyTree;

import java.io.IOException;

public class Service<E extends Creatures> {
    private FamilyTree<E> tree;

    public Service(){
        tree = new FamilyTree<>();
    }

    public void loadFamilyTreeFromFile(ReadAndWrite readAndWrite, String path) throws IOException, ClassNotFoundException {
        tree = (FamilyTree) readAndWrite.read(path);
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семейного древа:\n");
        for (Creatures creature: tree){
            stringBuilder.append(creature);
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
