package FamilyTree_homework.model;


import FamilyTree_homework.model.Humans.Gender;
import FamilyTree_homework.model.Humans.Human;
import FamilyTree_homework.model.familyTree.FamilyTree;
import FamilyTree_homework.model.save.FileHandlerForFamilyTree;
import FamilyTree_homework.model.save.Writable;

import java.time.LocalDate;

public class FamilyTreeService {
    private Writable writable;
    private static FamilyTree<Human> activeTree;

    public FamilyTreeService(FamilyTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public FamilyTreeService(){
        writable = new FileHandlerForFamilyTree();
        activeTree = new FamilyTree<>();
    }

    public static void sortByAge() {
        activeTree.sortByAge();
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
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

    public String addHuman(String name, String genderString, String birthDate,
                           String deathDate, long idFather, long idMother){

        Human father = activeTree.getById(idFather);
        Human mother = activeTree.getById(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate BirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, BirthDate,null, father, mother);
        if (!deathDate.equals("0")){
            try {
                LocalDate DeathDate = LocalDate.parse(deathDate);
                human.setDeathDate(DeathDate);
            }catch (Exception e){
                System.out.println("Дата смерти неизвестна");
            }
        }
        activeTree.add(human);
        return "Человек успешно добавлен в дерево";
    }

    public static void sortByName(){
        activeTree.sortByName();
    }

    public static void sortByDeathDate(){
        activeTree.sortByDeathDate();
    }


    public String getHumanList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human : activeTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return activeTree.getInfo();
    }
}
