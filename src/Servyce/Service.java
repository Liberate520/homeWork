package HomeWork.familyTree.homeWork22_10_23.src.Servyce;

import HomeWork.familyTree.homeWork22_10_23.src.Gender;
import HomeWork.familyTree.homeWork22_10_23.src.HumanBuilder;
import HomeWork.familyTree.homeWork22_10_23.src.human.Human;
import HomeWork.familyTree.homeWork22_10_23.src.tree.FamilyTree;

import java.time.LocalDate;
import java.util.Iterator;

public class Service {
    private FamilyTree familyTree;
    private HumanBuilder builder;

    public Service(){
        familyTree = new FamilyTree();
        builder = new HumanBuilder();
    }
    public void addHuman(String surname, String name, String patronymic, LocalDate birthDay, Gender gender){
        Human human = builder.build(surname,name,patronymic,birthDay,gender);
        familyTree.addHuman(human);
        }


    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей : \n");
        Iterator<Human> iterator = familyTree.iterator();
        for(Human human:familyTree){
            stringBuilder.append(human.getId());
            stringBuilder.append(" ");
            stringBuilder.append(human.getSurname());
            stringBuilder.append(human.getName());
            stringBuilder.append(human.getPatronymic());
            stringBuilder.append(human.getAge().getYear());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortBySurname(){
        familyTree.sortBySurname();
    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByAge(){
        familyTree.sortByAge();
    }
    public String toString(){
        return getHumanListInfo();
    }
}
