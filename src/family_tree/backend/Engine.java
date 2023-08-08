package family_tree.backend;

import family_tree.backend.config.BaseInit;
import family_tree.backend.config.Config;
import family_tree.backend.config.HumanExample;
import family_tree.backend.ftree.FamilyTree;
import family_tree.backend.person.Gender;
import family_tree.backend.person.Person;
import family_tree.backend.dump_file.FileHandler;

import java.time.LocalDate;

public class Engine {

    private long recID;
    private FamilyTree<Person> relations;

    private boolean initDone;
    private boolean exampleBase;

    public Engine(){
        initDone = false;
        relations = new FamilyTree<>();
        this.recID = relations.setNextID();
    }

    public void addObjRecord(String lName, String fName, Gender gender, LocalDate birthDate) {
        if (exampleBase == true){
            relations.clear();
            Person.nullCount();
            exampleBase = false;
        }
        Person rec = new Person(fName, lName, gender, birthDate);
        relations.addPerson(rec);
        saveWorkDump();

    }
    private void saveWorkDump(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveDump(relations, getDump());
    }

    private void readWorkDump(){
        FileHandler fileHandler = new FileHandler();
        relations = (FamilyTree) fileHandler.readDump(getInit());
    }

    public String getTree() {
        if (!initDone){getBase();}
        return relations.getFullRelativesInfo();
    }

    public String getUnitTree(long id) {
        if (!initDone){getBase();}
        return relations.getUnitPersonalTree(id);
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
            relations = HumanExample.makePreviewTree();
            exampleBase = true;
        } else {
            readWorkDump();
            setIDCount();
            exampleBase = false;
        }
        if (relations != null){
            initDone = true;
        }
    }

    private void setIDCount(){
        Person.setCount(relations.setNextID());
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

    public void setRelations(int unit,int relative, String relation){
        if (relation == "parent"){
            relations.setParents(unit,relative);
        } else {
            String[] mDate=relation.split("-");
            LocalDate dateOfM = LocalDate.of(Integer.parseInt(mDate[2]),Integer.parseInt(mDate[1]),Integer.parseInt(mDate[0]));
            relations.setUnitMarriage(unit,"marriage name", relative,dateOfM);
        }
        saveWorkDump();
    }
}
