package family_tree.backend;

import family_tree.backend.config.BaseInit;
import family_tree.backend.config.Config;
import family_tree.backend.config.Example;
import family_tree.backend.ftree.FamilyTree;
import family_tree.backend.person.Gender;
import family_tree.backend.person.Person;
import family_tree.backend.dump_file.FileHandler;

import java.time.LocalDate;

public class Engine {

    private FamilyTree<Person> relations;

//    private int id;
    private boolean initDone;
    private boolean exampleBase;

    public Engine(){
        initDone = false;
        relations = new FamilyTree<>();
    }

    public void addPerson(String lName, String fName, Gender gender, LocalDate birthDate) {
        if (exampleBase == true){
            relations.clear();
            Person.nullCount();
            exampleBase = false;
        }
        Person rec = new Person(fName, lName, gender, birthDate);
        relations.addPerson(rec);
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveDump(relations, getDump());

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

    public String getDump(){
        BaseInit init = new Config();
        return init.dumpFilePath();
    }

    public void getBase(){
        if (getInit() == null){
            relations = Example.makePreviewTree();
            exampleBase = true;
        } else {
            FileHandler fileHandler = new FileHandler();
            relations = (FamilyTree) fileHandler.readDump(getInit());
            long tid = 0;
            for (Person person: relations){
                if (tid < person.getID()){
                    tid = person.getID();
                }
            }
            Person.setCount(tid + 1);

            exampleBase = false;
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
