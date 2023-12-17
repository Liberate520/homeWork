package FamilyTree.model;

import FamilyTree.model.FT.FamTree;
import FamilyTree.model.HR.Gender;
import FamilyTree.model.HR.Human;
import FamilyTree.model.Saver.Writable;

import java.time.LocalDate;

public class ServiceModPres {
    private Writable writable;
    private FamTree<Human> activeTree;

    public ServiceModPres(FamTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public ServiceModPres(){
        activeTree = new FamTree<>();
    }

//    private static FamTree load() {
//        String savePath = "src/FamilyTree/saver/tree.txt";
//        FileHandler fileHandler = new FileHandler();
//        return (FamTree) fileHandler.load(savePath);
//    }
//
//    private static void save(FamTree tree) {
//        String savePath = "src/FamilyTree/saver/tree.txt";
//        FileHandler fileHandler = new FileHandler();
////        fileHandler.save(tree, savePath);
//        if (fileHandler.save((Serializable) tree, savePath)) {
//            System.out.println("каталог сохранён");
//        }
//        else {
//            System.out.println("проверьте параметры сохранения");
//        }
//    }

    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(activeTree);
    }

    public boolean load(){
        if (writable == null){
            return false;
        }
        activeTree = writable.load();
        return true;
    }

    public String addHuman(String name, String genderString, String birthDate,
                           int fatherId, int motherId){
        Human father = activeTree.getById(fatherId);
        Human mother = activeTree.getById(motherId);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate, father, mother);
        activeTree.add(human);
        return "Человек успешно добавлен в дерево";
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByDeathDate(){
        activeTree.sortByBirthDate();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }
}
