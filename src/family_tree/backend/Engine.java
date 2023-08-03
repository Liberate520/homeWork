package family_tree.backend;

import family_tree.backend.config.BaseInit;
import family_tree.backend.config.Config;
import family_tree.backend.config.Example;
import family_tree.backend.ftree.FamilyTree;
import family_tree.backend.person.Gender;
import family_tree.backend.person.Person;

import java.time.LocalDate;

public class Engine{

    private FamilyTree<Person> relations;

//    private int id;
    private boolean initDone;

    public Engine(){
        initDone = false;
        relations = new FamilyTree<>();
    }

    public void addPerson(String lName, String fName, Gender gender, LocalDate birthDate) {
        Person rec = new Person(fName, lName, gender, birthDate);
        relations.addPerson(rec);
    }

    public String getTree() {
        if (!initDone){getBase();}
        return relations.getFullRelativesInfo();
    }

    public String getPersonTree(long id) {
        if (!initDone){getBase();}
        return relations.getPersonalTree(id);
    }

    public String getInit(){
        BaseInit init = new Config();
        return init.baseInit();
    }

    public void getBase(){
        if (getInit() == null){
            relations = Example.makePreviewTree();
        } else {
        }
        if (relations != null){
            initDone = true;
        }
    }

    public void sortTreeByBirthDays() {
        relations.sortByBirthDays();
    }

    public void sortTreeByNames() {
        relations.sortByNames();
    }

    public void sortTreeByID() {
        relations.sortByID();
    }
}
