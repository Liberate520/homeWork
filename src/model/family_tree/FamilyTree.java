package model.family_tree;

import model.file_handler.FileHandler;
import model.service.Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem<E>> implements Serializable, Iterable<E> {
    private static final long serialVersionUID = 1L;
    private long countPeople;
    public List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public boolean addHumanInTree(E human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            human.setId(countPeople++);
            System.out.println("Человек добавлен в древо!");
            System.out.println();
            return true;
        }
        System.out.println("Возникла ошибка при добавлении человека в древо");
        System.out.println();
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!(familyTree.isEmpty())) {
            for (E human : familyTree) {
                    sb.append("Id:" + human.getId() + " " + human.getName() + " Возраст: " + human.getAge() + " ");
                    if(!human.getChild().isEmpty()){
                        sb.append("Дети: " +"\n"+ human.getChild());
                    }
                    sb.append("\n");
            }
        }
        return sb.toString();
    }
    public void sortByName(){
        familyTree.sort(new SortByAgeComparator<>());
    }

    public void sortByAge(){
        familyTree.sort(new SortByAgeComparator<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(familyTree);
    }

    public void save(Service service){ //Familytree familytree
        String filePath = "src/model/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(service,filePath); //familytree
    }

    public Service load(){
        String filePath = "src/model/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (Service) fileHandler.read(filePath);
    }
}
