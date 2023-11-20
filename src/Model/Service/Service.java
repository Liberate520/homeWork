package Model.Service;

import Model.human.Gender;
import Model.human.Human;
import Model.tree.FamilyTree;
import Model.tree.FamilyTreeItem;
import Model.writer.FileHandler;
import Model.writer.Writable;

import java.time.LocalDate;

public class Service<T extends FamilyTreeItem<Human>>  {
    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
//        Human human1 = new Human(1, "Кузнецов", "Владислав", LocalDate.of(1983, 5, 1), Gender.Male);
//        Human human2 = new Human(2, "Березянская", "Ольга", LocalDate.of(1989, 2, 20), Gender.Female);
//        Human human3 = new Human(3, "Кузнецов", "Юрий", LocalDate.of(1944, 7, 4), Gender.Male);
//        Human human4 = new Human(4, "Афонченко", "Людмила", LocalDate.of(1948, 8, 23), Gender.Female);
//        Human human5 = new Human(5, "Березянский", "Игорь", LocalDate.of(1960, 5, 26), Gender.Male);
//        Human human6 = new Human(6, "Березянская", "Наталья", LocalDate.of(1964, 5, 28), Gender.Female);
//        Human human7 = new Human(7, "Афонченко", "Федор", LocalDate.of(1921, 02, 23), Gender.Male);
//        Human human8 = new Human(8, "Ильченко", "Талия", LocalDate.of(1924, 4, 1), Gender.Female);
//        Human human9 = new Human(9, "Афонченко", "Ирина", LocalDate.of(1959, 9, 2), Gender.Female);
//        Human human10 = new Human(10, "Кузнецова", "Ирина", LocalDate.of(2014, 3, 26), Gender.Female);
//        Human human11 = new Human(11, "Кушнарева", "Людмила", LocalDate.of(1933, 2, 15), Gender.Female);
//        familyTree.addHuman(human1);
//        familyTree.addHuman(human2);
//        familyTree.addHuman(human3);
//        familyTree.addHuman(human4);
//        familyTree.addHuman(human5);
//        familyTree.addHuman(human6);
//        familyTree.addHuman(human7);
//        familyTree.addHuman(human8);
//        familyTree.addHuman(human9);
//        familyTree.addHuman(human10);
//        familyTree.addHuman(human11);

    }

    public Service(FamilyTree< Human > familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(Human human){

        familyTree.addHuman(human);
//        System.out.println(getHumanListInfo());
    }


    public String getHumanListInfo(){
        return familyTree.allTree();
    }

    public FamilyTree< Human > getFamilyTree() {
        return familyTree;
    }

    public void read(){
        familyTree = load();
        System.out.println(familyTree.allTree());
    }

    public FamilyTree<Human> load() {
        Writable fileHandler = new FileHandler();
        String filePath = "src/Model/writer/tree.txt";
        System.out.println("Загрузка файла: ");
        return (FamilyTree<Human>) fileHandler.read(filePath);
    }

    public void save(){
        Writable fileHandler = new FileHandler();
        String filePath = "src/Model/writer/tree.txt";
        boolean saved = fileHandler.save(familyTree, filePath);
        System.out.println("Сохранение файла: " + saved);
    }

    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByLastname(){
        familyTree.sortByLastname();
    }
    public void sortByAge(){
        familyTree.sortByAge();
    }

    public String searchByNameSurname(String name){
        return familyTree.SearchByNameSurname(name);
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }
}
