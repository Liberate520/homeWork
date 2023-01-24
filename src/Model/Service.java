package Model;

import Model.tree.*;

public class Service {

    TempStorage tempStorage;


    public Service() {
        this.tempStorage = new TempStorage();
    }

    public void CreateButtonOnClick(String name) {
        System.out.println("Выполнена команда создать " + name);
    }

    public void SaveButtonOnClick(String name) {
        System.out.println("Выполнена команда сохранить " + name);
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

    public void PrintContainerButtonOnClick() {
        System.out.println(tempStorage);
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
