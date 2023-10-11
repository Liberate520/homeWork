package Model.service;

import Model.builder.MyHumanBuilder;
import Model.familyTree.FamilyTree;
import Model.fileHandler.FileHandler;
import Model.obj.Gender;
import Model.obj.human.Human;

import java.time.LocalDate;

public class Service {

    private MyHumanBuilder builderHuman;
    private FamilyTree<Human> tree;



    public Service() {
        builderHuman = new MyHumanBuilder();
        tree = new FamilyTree();
    }


//    public void addHuman(String fstName, String lstName, LocalDate bornDate, LocalDate deathDate, Gender gender, Human mother, Human father){
//        Human human = builderHuman.createHuman(fstName,lstName,bornDate,deathDate,gender,mother,father);
//    }

    public void addHuman(String fstName, String lstName, LocalDate bornDate, LocalDate deathDate, Gender gender) {
        Human human = builderHuman.createHuman(fstName,lstName,bornDate,deathDate,gender);
        tree.addObj(human);
    }

    public void addHumanParent(int cId, int pId){
        Human c = tree.getById(cId);
        Human p = tree.getById(pId);
        p.addChild(c);
        c.addParent(p);
    }



    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список людей:\n");
        for (Human student : tree){
            sb.append(student);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByFstName(){
        tree.sortByFirstName();
    }

    public void sortByLstName(){
        tree.sortByLastName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void sortByBornDate(){
        tree.sortByBornDate();
    }

    public void saveTree() {
        FileHandler fh = new FileHandler();
        fh.save(tree,"tree.txt");
    }

    public void readTree() {
        FileHandler fh = new FileHandler();
        tree = (FamilyTree<Human>) fh.read("tree.txt");
    }
}
