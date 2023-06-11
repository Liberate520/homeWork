package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree tree;

    public Service() {

        Human human1 = new Human("O-647", LocalDate.of(2078,4,12), Gender.MALE);
        Human human2 = new Human("I-693", LocalDate.of(2079,6,17), Gender.FEMALE);
        Human human3 = new Human("K-953", LocalDate.of(2101,1,4), Gender.MALE, human1, human2);
        Human human4 = new Human("P-328", LocalDate.of(2101,1,4), Gender.FEMALE, human1, human2);
        Human human5 = new Human("L-493", LocalDate.of(2104,7,19), Gender.MALE, human1, human2);
        Human human6 = new Human("M-727", LocalDate.of(2134,11,6), Gender.FEMALE, human4, human5);
        Human human7 = new Human("U-952", LocalDate.of(2134,2,17), Gender.FEMALE, human4, human5);
        human1.addChild(human3);
        human1.addChild(human4);
        human1.addChild(human5);
        human2.addChild(human3);
        human2.addChild(human4);
        human2.addChild(human5);
        human4.addChild(human6);
        human4.addChild(human7);
        human5.addChild(human6);
        human5.addChild(human7);

        tree = new FamilyTree<>();
        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.addHuman(human3);
        tree.addHuman(human4);
        tree.addHuman(human5);
        tree.addHuman(human6);
        tree.addHuman(human7);
    }

    public void showList(){
        System.out.println(tree.printHumanList());
    }
    public void sortByName(){
        tree.getHumanList().sort(new HumanComparatorByName());
    }

    public void sortByBirthDate(){
        tree.getHumanList().sort(new HumanComparatorByBirthDate());
    }
    public void addHuman(Human human){
        //Human newHuman = human;
        tree.addHuman(human);
    }
    public String findByName(String name){
        if (tree.getByName(name) == null){return "Запись не найдена";}
        System.out.println("Запись найдена");
        return tree.getByName(name).toString();
    }

    public String findBrothers(String name){
        if (tree.getByName(name) == null){return "Запись не найдена";}
        List<Human> brothersList = tree.findBrothers(tree.getByName(name));
        String printer = "Найдено " + brothersList.size() + " братьев" + "\n";
        for(Human item : brothersList){
            printer += item.toString() + "\n";
        }
        return printer;
    }

    public void SaveToFile(String filename) throws IOException {
        Savable savableSaver = new model.FileHandler();
        savableSaver.save(tree, filename);
    }

    public void LoadFromFile(String filename) throws IOException, ClassNotFoundException {
        Savable savableLoader = new model.FileHandler();
        model.FamilyTree familyTreeRestored = (FamilyTree) savableLoader.load(filename);

    }
}
