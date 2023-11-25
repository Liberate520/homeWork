package Family_Tree.model.Service;

import Family_Tree.model.Writer.FileHandler;
import Family_Tree.model.Human.Human;
import Family_Tree.model.Human.Gender;
import Family_Tree.model.Tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private FileHandler<Human> storage = new FileHandler();

    public Service() {
        tree = new FamilyTree<>();
    }

//    public void addHuman (String name, int age){
//        Human human = builder.build(name, age);
//        wholeTree.addHuman(human);
//    }
    public boolean add(String name, LocalDate birthday, Gender gender) {
        Human human = new Human(name, birthday, gender);
        tree.add(human);
        return true;
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родственников: \n");
        for (Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByBirthday(){
        tree.sortByBirthday();
    }

    @Override
    public String toString(){
        return getHumanListInfo();
    }

//    public boolean restoreTree(String filePath) {
//        FamilyTree<Human> tmpTree = new FamilyTree<Human>();
//        tmpTree = storage.restoreTree(filePath);
//        if (tmpTree.equals(null)) {
//            return false;
//        }
//        tree = tmpTree;
//        return true;
//    }
//
//    public boolean saveTree(String fileName) {
//        return storage.writeTree(tree, fileName);
//    }
//
//
//    public void setParent(int person_id, int parent_id) {
//        Human human = tree.getPersonById(person_id);
//        human.addParent(tree.getPersonById(parent_id));
//    }
//
//    public boolean checkId(int id) {
//        return tree.checkId(id);
//    }
//
//    public String getFamilyInfo() {
//        return tree.toString();
//    }
//
//    public String listSortByAge() {
//        StringBuilder tmp = new StringBuilder();
//        for (String str : tree.sortByAge()) {
//            tmp.append(str);
//            tmp.append("\n");
//        }
//        return tmp.toString();
//    }
//
//    public String listSortByChildren() {
//        StringBuilder tmp = new StringBuilder();
//        for (String str : tree.sortByChildren()) {
//            tmp.append(str);
//            tmp.append("\n");
//        }
//        return tmp.toString();
//
//    }
}
