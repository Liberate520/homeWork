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
//        System.out.println("Presenter:00");
        engine.getInit();
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
//        System.out.println("Presenter:01");
        engine.sortTreeByBirthDays();
        getFamilyTree();
    }

    public void sortByName() {
//        System.out.println("Presenter:02");
        engine.sortTreeByNames();
        getFamilyTree();
    }

    public void sortByID() {
//        System.out.println("Presenter:03");
        engine.sortTreeByID();
        getFamilyTree();
    }
}
