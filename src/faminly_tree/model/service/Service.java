package faminly_tree.model.service;

import faminly_tree.model.human.HumanConnection;
import faminly_tree.model.human.Gender;
import faminly_tree.model.human.Human;
import faminly_tree.model.save_in_file.SaveInFile;
import faminly_tree.model.tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;
//Сервис делает много всего, но я так понимаю, что его основная задача это связь между презентером и элементами модели,
// по идее здесь нарушается пятый принцип: например, если изменится конструктор класса Human, сломается метод addHuman,
// так же он зависит от класса SaveInFile. Получается нужен интерфейс, который свяжет сервис с теми классами,
// к которым он обращается, чтобы обеспечить уверенность в том, что эти методы там будут и с нужными параметрами.
// А чтобы при этом не нарушить четвертый принцип, нужно сделать несколько интерфейсов, каждый под свой класс,
// потому что методы в них разные
public class Service {
    private FamilyTree tree;
    private SaveInFile save;
    private Human human;
    private HumanConnection humanConnection;
    public Service() {
        this.tree = new FamilyTree<>();
        this.save = new SaveInFile();
        this.humanConnection = new HumanConnection();
    }
    /*public void addHuman(String name, Gender gender, LocalDate birth){
        Human human = new Human(name, gender, birth);
        tree.addToTree(human);
    }*/
    public void addHuman(){
        this.human = new Human();
    }
    public void sortByAge() {
        tree.sortByAge();
    }
    public void sortByName() {
        tree.sortByName();
    }
    public void sortByID(){
        tree.sortByID();
    }
    public void showAllTree() {
        System.out.println(tree);
    }
    public boolean connection(int parentID, int childID){
        Human child = (Human)tree.getHumanByID(childID);
        Human parent = (Human)tree.getHumanByID(parentID);
        if (child == null || parent == null) return false;
        humanConnection.childFor(child, parent);
        return true;
    }
    public boolean save(String path) {
        try{
            save.write(path, tree);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public boolean dowland(String path) {
        try{
            this.tree = (FamilyTree) save.readTree(path);
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }
    public void nextOfKin(int humanID) {
        Human human = (Human) tree.getHumanByID(humanID);
        if (human == null) System.out.println("Такого человека нет в семейном древе");
        System.out.println(tree.nextOfKin(human));
    }
    public int treeIsEmpty(){
        return tree.getSize();
    }
    public void setHumanName(String name) {
        human.setName(name);
    }
    public void setHumanPatronymic(String patronymic) {
        human.setPatronymic(patronymic);
    }
    public void setHumanSurname(String surname) {
        human.setSurname(surname);
    }
    public void addHumanToTree() {
        tree.addToTree(human);
    }
    public void setHumanBirth(LocalDate date) {
        human.setBirth(date);
    }
}
