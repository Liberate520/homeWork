package model.service;

import java.time.LocalDate;
import java.util.logging.FileHandler;
import model.family_tree.FamilyTree;
import model.service.Human.Gender;
import model.service.Human.Human;

public class Service {
    long id;
    String filePath = "src/family_tree/model/ftree.out";
    FileHandler fileHandler = new FileHandler();
    private FamilyTree<Human> tree;
    
    public Service(){
    }


    public void addHuman(String name, LocalDate dateOfBirth, String pol){
        Gender gender = null;
        if (pol.equalsIgnoreCase("Male"))
            gender = Gender.Male;
        else gender = Gender.Female;
        Human human = new Human(name, dateOfBirth, null, gender, null, null, null);
        tree.add(human);
    }

    public void sortByName(){
        tree.sortByName();
    }
    public void sortByAge(){
        tree.sortByAge();
    }
    public void sortById(){
        tree.sortById();
    }
    public void remove(long id){
        tree.remove(id);
    }
    public void setWedding(long id1, long id2){
        tree.setWedding(id1, id2);
    }
    public void setDivorce(long id1, long id2){
        tree.setDivorce(id1, id2);
    }
    public String getTreeInfo(){
        return tree.getInfo();
    }
    
    public void load(){
        tree = (FamilyTree) fileHandler.load(filePath);
        if (tree == null) tree = makeTree();
    }
    public void save(){
        fileHandler.save(tree, filePath);
    }
    
    static FamilyTree makeTree(){
        FamilyTree tree = new FamilyTree();

        Human roza = new Human("Захарова Роза Карповна", Gender.Male, LocalDate.of(1958,4,12));
        Human nikolay = new Human("Федотов Николай Петрович", Gender.Female, LocalDate.of(1953,1,17));

        tree.add(roza);
        tree.add(nikolay);

        nikolay.setSpouse(roza);
        roza.setSpouse(nikolay);

        Human marina = new Human("Федотова Марина Николаевна", Gender.Female, LocalDate.of(1975,9,1), roza, nikolay);
        tree.add(marina);

        // nikolay.addChild(marina);
        // roza.addChild(marina);
        // marina.addParent(nikolay);
        // marina.addParent(roza);
            
        Human sergey = new Human("Гаврилов Сергей Олегович", Gender.Male, LocalDate.of(1975,8,26));
        tree.add(sergey);

        tree.setWedding(sergey.getId(), marina.getId());
            
        Human arina = new Human("Гаврилова Арина Сергеевна", Gender.Female, LocalDate.of(1998,8,13));
        tree.add(arina);
            
        sergey.addChild(arina);
        marina.addChild(arina);
        arina.addParent(sergey);
        arina.addParent(marina);

        Human polina = new Human("Гаврилова Полина Сергеевна", Gender.Female, LocalDate.of(2004,11,9));
        tree.add(polina);

        sergey.addChild(polina);
        marina.addChild(polina);
        polina.addParent(sergey);
        polina.addParent(marina);

        return tree;
        }
    }

