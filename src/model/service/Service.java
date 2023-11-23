package model.service;

import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;
import model.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;


    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
//        Human human1 = new Human(1, "Кузнецов", "Владислав", LocalDate.of(1983, 5, 1), null, Gender.Male);
//        Human human2 = new Human(2, "Березянская", "Ольга", LocalDate.of(1989, 2, 20), null, Gender.Female);
//        Human human3 = new Human(3, "Кузнецов", "Юрий", LocalDate.of(1944, 7, 4), null, Gender.Male);
//        Human human4 = new Human(4, "Афонченко", "Людмила", LocalDate.of(1948, 8, 23),null, Gender.Female);
//        Human human5 = new Human(5, "Березянский", "Игорь", LocalDate.of(1960, 5, 26),null, Gender.Male);
//        Human human6 = new Human(6, "Березянская", "Наталья", LocalDate.of(1964, 5, 28),null, Gender.Female);
//        Human human7 = new Human(7, "Афонченко", "Федор", LocalDate.of(1921, 02, 23),null, Gender.Male);
//        Human human8 = new Human(8, "Ильченко", "Талия", LocalDate.of(1924, 4, 1),null, Gender.Female);
//        Human human9 = new Human(9, "Афонченко", "Ирина", LocalDate.of(1959, 9, 2),null, Gender.Female);
//        Human human10 = new Human(10, "Кузнецова", "Ирина", LocalDate.of(2014, 3, 26),null, Gender.Female);
//        Human human11 = new Human(11, "Кушнарева", "Людмила", LocalDate.of(1933, 2, 15),null, Gender.Female);
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

    public void addHuman(String info){
        List list = List.of(info.split(", "));
        int id = Integer.parseInt(list.get(0).toString());
        String lastname = list.get(1).toString();
        String name = list.get(2).toString();
        List< String > dateBirth = List.of(list.get(3).toString().split("-"));
        List< String > dateDeath = List.of(list.get(4).toString().split("-"));
        LocalDate birth = setDate(dateBirth, 0,1,2);
        LocalDate death = setDate(dateDeath, 0,1,2);
        Gender gender = setGender(list);
        Human human = new Human(id, lastname, name, birth, death, gender);
        familyTree.addHuman(human);
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

    private FamilyTree<Human> load() {
        fileHandler = new FileHandler();
        String filePath = "src/model/writer/tree.txt";
        System.out.println("Загрузка файла: ");
        return (FamilyTree<Human>) fileHandler.read(filePath);
    }

    public void save(){
        fileHandler = new FileHandler();
        String filePath = "src/model/writer/tree.txt";
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
    public void sortById(){
        familyTree.sortById();
    }

    public String searchByNameSurname(String name){
        return familyTree.SearchByNameSurname(name);
    }

    public void setChild(Human parent, Human child){
        parent.setChild(child);
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }

    public void getId(Human human) {

    }

    public Human searchById(int idHuman) {
        return familyTree.searchById(idHuman);
    }
    private LocalDate setDate(List date, int indexY, int indexM, int indexD){
        int year = Integer.parseInt(date.get(0).toString());
        int month = Integer.parseInt(date.get(1).toString());
        int day = Integer.parseInt(date.get(2).toString());
        LocalDate dateOut = LocalDate.of(year, month, day);
        return dateOut;
    }
    private Gender setGender(List list){
        Gender gender;
        if(list.get(5).toString().contains("Male"))
            gender = Gender.Male;
        else gender = Gender.Female;
        return gender;
    }
}
