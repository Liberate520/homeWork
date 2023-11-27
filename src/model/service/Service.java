package model.service;

import model.Builder.HumanBuilder;
import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;
import model.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;
    private HumanBuilder builder;
    private FamilyTree<Human> familyList;


    public Service() {
        familyList = new FamilyTree<>();
        fileHandler = new FileHandler();
        builder = new HumanBuilder();
//        Human human1 = builder.build("Кузнецов", "Владислав", LocalDate.of(1983, 5, 1), null, Gender.Male);
//        Human human2 = builder.build( "Березянская", "Ольга", LocalDate.of(1989, 2, 20), null, Gender.Female);
//        Human human3 = builder.build( "Кузнецов", "Юрий", LocalDate.of(1944, 7, 4), null, Gender.Male);
//        Human human4 = builder.build( "Афонченко", "Людмила", LocalDate.of(1948, 8, 23),null, Gender.Female);
//        Human human5 = builder.build( "Березянский", "Игорь", LocalDate.of(1960, 5, 26),null, Gender.Male);
//        Human human6 = builder.build( "Березянская", "Наталья", LocalDate.of(1964, 5, 28),null, Gender.Female);
//        Human human7 = builder.build( "Афонченко", "Федор", LocalDate.of(1921, 02, 23),null, Gender.Male);
//        Human human8 = builder.build( "Ильченко", "Талия", LocalDate.of(1924, 4, 1),null, Gender.Female);
//        Human human9 = builder.build( "Афонченко", "Ирина", LocalDate.of(1959, 9, 2),null, Gender.Female);
//        Human human10 = builder.build( "Кузнецова", "Ирина", LocalDate.of(2014, 3, 26),null, Gender.Female);
//        Human human11 = builder.build( "Кушнарева", "Людмила", LocalDate.of(1933, 2, 15),null, Gender.Female);
//        familyList.addHuman(human1);
//        familyList.addHuman(human2);
//        familyList.addHuman(human3);
//        familyList.addHuman(human4);
//        familyList.addHuman(human5);
//        familyList.addHuman(human6);
//        familyList.addHuman(human7);
//        familyList.addHuman(human8);
//        familyList.addHuman(human9);
//        familyList.addHuman(human10);
//        familyList.addHuman(human11);


    }

    public void addHuman(List info){
//        List list = List.of(info.split(", "));
//        int id = Integer.parseInt(list.get(0).toString());
//        String lastname = list.get(1).toString();
//        String name = list.get(2).toString();
//        List< String > dateBirth = List.of(list.get(3).toString().split("-"));
//        List< String > dateDeath = List.of(list.get(4).toString().split("-"));
//        LocalDate birth = setDate(dateBirth, 0,1,2);
//        LocalDate death = setDate(dateDeath, 0,1,2);
//        Gender gender = setGender(list);
//        Human human = new Human(id, lastname, name, birth, death, gender);
//        familyTree.addHuman(human);
        String lastname = info.get(0).toString();
        String name = info.get(1).toString();
        LocalDate birth = (LocalDate) info.get(2);
        LocalDate death = (LocalDate) info.get(3);
        Gender gender = setGender(info);
        Human human = builder.build(lastname, name, birth, death, gender);
        familyList.addHuman(human);
    }

    public String getHumanListInfo(){
        return familyList.allTree();
    }

    public FamilyTree< Human > getFamilyTree() {
        return familyList;
    }

    public void read(){
        familyList = load();
        System.out.println(familyList.allTree());
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
        boolean saved = fileHandler.save(familyList, filePath);
        System.out.println("Сохранение файла: " + saved);
    }

    public void sortByName(){
        familyList.sortByName();
    }
    public void sortByLastname(){
        familyList.sortByLastname();
    }
    public void sortByAge(){
        familyList.sortByAge();
    }
    public void sortById(){
        familyList.sortById();
    }

    public String searchByNameSurname(String name){
        return familyList.SearchByNameSurname(name);
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
        return familyList.searchById(idHuman);
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
        if(list.get(4).toString().contains("Male"))
            gender = Gender.Male;
        else gender = Gender.Female;
        return gender;
    }
}
