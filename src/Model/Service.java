package Model;

import Model.tree.*;

import java.io.IOException;
import java.util.Collections;

public class Service {

    private TempStorage tempStorage;


    public Service() {
        this.tempStorage = new TempStorage();
    }

    public TempStorage getTempStorage() {
        return tempStorage;
    }

    public String saveButtonOnClick() throws IOException {
            FileWorker fileWorker = new FileWorker();
            StringBuilder userMessage = new StringBuilder();

            for (Containerable human : tempStorage.getHumanContainer().getContainer()) {
                fileWorker.writeCreatureToFile((Human) human);
                userMessage.append(((Human) human).getFullName()).append(" успешно сохранен\n");
            }

            for (Containerable cat : tempStorage.getCatContainer().getContainer()) {
                fileWorker.writeCreatureToFile((Cat) cat);
                userMessage.append(((Cat) cat).getFullName()).append(" успешно сохранен\n");
            }

            for (Containerable tree : tempStorage.getHumanTreeContainer().getContainer()) {
                fileWorker.writeTreeToFile((FamilyTree<Human>) tree);
                userMessage.append(((FamilyTree<Human>) tree).getName()).append(" успешно сохранено\n");
            }

            for (Containerable tree : tempStorage.getCatTreeContainer().getContainer()) {
                fileWorker.writeTreeToFile((FamilyTree<Cat>) tree);
                userMessage.append(((FamilyTree<Cat>) tree).getName()).append(" успешно сохранено\n");
            }

        return userMessage.toString();
    }

    public void exitButtonOnClick(){
        System.exit(0);
    }

    public String createCatButtonOnClick(String name, Gender gender, Integer age){
        Cat cat = new Cat(name, gender, age);
        this.tempStorage.getCatContainer().getContainer().add(cat);
        return cat.getFullName();
    }

    public String createHumanButtonOnClick(String name, Gender humanGender, Integer humanAge) {
        Human human = new Human(name, humanGender, humanAge);
        this.tempStorage.getHumanContainer().getContainer().add(human);
        return human.getFullName();
    }

    public TempStorage printContainerButtonOnClick() {
        return getTempStorage();
    }

    public String createHumanTreeButtonOnClick(String name) {
        FamilyTree<Human> familyTree = new FamilyTree<>(name);
        this.tempStorage.getHumanTreeContainer().getContainer().add(familyTree);
        return familyTree.getName();
    }

    public String createCatTreeButtonOnClick(String name) {
        FamilyTree<Cat> familyTree = new FamilyTree<>(name);
        this.tempStorage.getCatTreeContainer().getContainer().add(familyTree);
        return familyTree.getName();
    }

    public void addHumanButtonOnClick(FamilyTree<Human> tree, Human human) {
        tempStorage.getHumanContainer().getContainer().remove(human);
        tree.addElement(human);
    }

    public void addCatButtonOnClick(FamilyTree tree, Cat cat) {
        tempStorage.getCatContainer().getContainer().remove(cat);
        tree.addElement(cat);
    }

    public Container<Human> getHumanContainer() {
        return tempStorage.getHumanContainer();
    }

    public Container getCatContainer() {
        return tempStorage.getCatContainer();
    }

    public Container<FamilyTree<Human>> getHumanTreeContainer() {
        return tempStorage.getHumanTreeContainer();
    }

    public Container<FamilyTree<Cat>> getCatTreeContainer() {
        return tempStorage.getCatTreeContainer();
    }

    public void sortByName(FamilyTree tree){
        Collections.sort(tree.getTreeElements(), new HumanComparatorByName());
    }

    public void sortByAge(FamilyTree tree){
        Collections.sort(tree.getTreeElements(), new HumanComparatorByAge());
    }

    public static String agePostfix(int age){
        int ageLastNumber = age % 10;
        boolean isExclusion = (age % 100 >= 11) && (age % 100 <= 14);
        String postfix = "";

        if (ageLastNumber == 1)
            postfix = "год";
        else if(ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9)
            postfix = "лет";
        else if(ageLastNumber >= 2 && ageLastNumber <= 4)
            postfix = "года";
        if (isExclusion)
            postfix = "лет";

        return postfix;
    }

    public static String countPostfix(int num)
    {
        String postfix;
        if(num == 11) postfix = "элементов";
        else if(("" + num).endsWith("1")) postfix = "элемента";
        else if(num > 11 && num < 15) postfix = "элементов";
        else if(num % 10 > 1 && num % 10 < 5) postfix = "элементов";
        else postfix = "элементов";

        return postfix;
    }
}
