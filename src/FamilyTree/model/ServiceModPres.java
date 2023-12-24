package FamilyTree.model;

import FamilyTree.model.FT.FamTree;
import FamilyTree.model.HR.Gender;
import FamilyTree.model.HR.Human;
import FamilyTree.model.Saver.Writable;

import java.time.LocalDate;

public class ServiceModPres {
    private Writable writable;
    private FamTree<Human> activeTree;

    public ServiceModPres(FamTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public ServiceModPres(){
        activeTree = new FamTree<>();
    }

    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(activeTree);
    }

    public boolean load(){
        if (writable == null){
            return false;
        }
        activeTree = writable.read();
        return true;
    }

//    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
//        this(name, gender, null, birthDate, null, mother, father);
//    }
    public String addHuman(String name, String genderString, String birthDate,
                           long fatherId, long motherId){
        Human father = activeTree.getById((int) fatherId);
        Human mother = activeTree.getById((int) motherId);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate, father, mother);
        activeTree.add(human);
        return "Человек успешно добавлен в дерево";
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByBirthDate(){
        activeTree.sortByBirthDate();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }
}
