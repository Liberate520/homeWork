package family_tree.gate;

import family_tree.backend.Engine;
import family_tree.backend.person.Gender;
import family_tree.iu.BaseUI;

import java.time.LocalDate;

public class Presenter {
    private BaseUI baseUI;
    private Engine engine;

    public Presenter(BaseUI baseUI){
        this.baseUI = baseUI;
        engine = new Engine();
    }

    public void initBase(){
        engine.getInit();
        engine.getBase();
    }

    public void addPerson(String lName, String fName, Gender gender, LocalDate birthDate){
        engine.addPerson(lName, fName, gender, birthDate);
    }

    public void getFamilyTree(){
        baseUI.printAnswer(engine.getTree());
    }

    public void getPersonTree(long id){
        baseUI.printAnswer(engine.getPersonTree(id));
    }

    public void sortByBirthDate() {
        engine.sortTreeByBirthDays();
        getFamilyTree();
    }

    public void sortByName() {
        engine.sortTreeByNames();
        getFamilyTree();
    }

    public void sortByID() {
        engine.sortTreeByID();
        getFamilyTree();
    }
}
