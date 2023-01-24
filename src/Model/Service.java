package Model;

import Model.tree.*;

import java.io.IOException;

public class Service {

    private TempStorage tempStorage;


    public Service() {
        this.tempStorage = new TempStorage();
    }

    public TempStorage getTempStorage() {
        return tempStorage;
    }

    public void CreateButtonOnClick(String name) {
        System.out.println("Выполнена команда создать " + name);
    }

    public void SaveButtonOnClick() throws IOException {
        FileWorker fileWorker = new FileWorker();

        for (Containerable human : tempStorage.getHumanContainer().getContainer()) {
            fileWorker.writeCreatureToFile((Human) human);
        }

        for (Containerable cat : tempStorage.getCatContainer().getContainer()) {
            fileWorker.writeCreatureToFile((Cat) cat);
        }

        for (Containerable tree : tempStorage.getHumanTreeContainer().getContainer()) {
            fileWorker.writeTreeToFile((FamilyTree<Human>) tree);
        }

        for (Containerable tree : tempStorage.getCatTreeContainer().getContainer()) {
            fileWorker.writeTreeToFile((FamilyTree<Cat>) tree);
        }
    }

    public void ExitButtonOnClick(){
        System.exit(0);
    }

    public void CreateCatButtonOnClick(String name, Gender gender, Integer age){
        Cat cat = new Cat(name, gender, age);
        System.out.println();
        System.out.println(cat);
        this.tempStorage.getCatContainer().getContainer().add(cat);
    }

    public void CreateHumanButtonOnClick(String name, Gender humanGender, Integer humanAge) {
        Human human = new Human(name, humanGender, humanAge);
        System.out.println();
        System.out.println(human);
        this.tempStorage.getHumanContainer().getContainer().add(human);
    }

    public TempStorage PrintContainerButtonOnClick() {
        return getTempStorage();
    }

    public void CreateHumanTreeButtonOnClick(String name) {
        FamilyTree<Human> familyTree = new FamilyTree<>(name);
        System.out.println();
        System.out.println(familyTree);
        this.tempStorage.getHumanTreeContainer().getContainer().add(familyTree);
    }

    public void CreateCatTreeButtonOnClick(String name) {
        FamilyTree<Cat> familyTree = new FamilyTree<>(name);
        System.out.println();
        System.out.println(familyTree);
        this.tempStorage.getCatTreeContainer().getContainer().add(familyTree);
    }

    public void AddHumanButtonOnClick(FamilyTree<Human> tree, Human human) {
        tempStorage.getHumanContainer().getContainer().remove(human);
        tree.addElement(human);
    }

    public void AddCatButtonOnClick(FamilyTree tree, Cat cat) {
        tempStorage.getCatContainer().getContainer().remove(cat);
        tree.addElement(cat);
    }

    public Container<Human> GetHumanContainer() {
        return tempStorage.getHumanContainer();
    }

    public Container GetCatContainer() {
        return tempStorage.getCatContainer();
    }

    public Container<FamilyTree<Human>> GetHumanTreeContainer() {
        return tempStorage.getHumanTreeContainer();
    }

    public Container<FamilyTree<Cat>> GetCatTreeContainer() {
        return tempStorage.getCatTreeContainer();
    }
}
