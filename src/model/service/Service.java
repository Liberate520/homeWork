package model.service;

import model.tree.FamilyTree;

import java.time.LocalDate;

import model.human.Gender;
import model.human.Human;
import model.save.writer.FileHandler;

public class Service {

    private FamilyTree<Human>  serviceTree;
    private FileHandler fileHandler;

    public Service(FamilyTree<Human> serviceTree) {
        this.serviceTree = serviceTree;
    }

    public Service() {
        serviceTree = new FamilyTree<Human> ();
        fileHandler = new FileHandler();
    }

    public FamilyTree<Human> getTree() {
        return serviceTree;
    }

    public void setTree(FamilyTree<Human> tree) {
        this.serviceTree = tree;
    }

    public void addHuman(String name, Gender gender, int age, LocalDate birthDate) {
        Human human = new Human(name, gender, age, birthDate);
        serviceTree.add(human);
        System.out.println("Человек успешно добавлен в дерево");
    }

    public void save() {
        fileHandler.save(serviceTree, "src\\tree.out");
        System.out.println("Экспорт в (tree.out) успешно завершён");
    }

    public void read() {
        FamilyTree<Human> familyTree = (FamilyTree<Human>) fileHandler.loading("src\\tree.out");
        System.out.println("Импорт из (tree.out) успешно завершён\n" + familyTree);
    }

    public void sortByName(){
        serviceTree.sortByName();
        System.out.println("Данные в дереве успешно отсортированы по имени людей");
    }

    public void sortByAge(){
        serviceTree.sortByAge();
        System.out.println("Данные в дереве успешно отсортированы по возрасту людей");
    }

    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве:\n");

        for (Object human : serviceTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getTreeInfo();
    }
}
