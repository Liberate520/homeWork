import familyTree.FamilyTree;
import person.Person;
import person.Relation;
import person.Sex;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private FamilyTree activeTree;
    private List<FamilyTree> familyTreeList;

    public Service(FamilyTree tree) {
        this.activeTree = tree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(tree);
    }

    public Service(){
        this(new FamilyTree());
    }

    public void addFamilyTree(FamilyTree familyTree){
        familyTreeList.add(familyTree);
    }

    public void addPerson(String firstName, String lastName, int age, Sex sex){
        activeTree.pushToTree(new Person(firstName, lastName, age, sex));
    }

    public void addPersonAs(String firstName, String lastName, int age, Sex sex,
                            String targetFirstName, String targetLastName, Relation relation){

        Person person = new Person(firstName, lastName, age, sex);
        activeTree.pushToTree(person);
        Person targetPerson = getPerson(targetFirstName, targetLastName);
        if (targetPerson != null) {  // Вроде необязательно
            switch (relation) {
                case Spouse: activeTree.pushSpouseToSet(targetPerson, person); break;
                case Father: activeTree.pushFatherToSet(targetPerson, person); break;
                case Mother: activeTree.pushMotherToSet(targetPerson, person); break;
                case Brother: activeTree.pushBrotherToSet(targetPerson, person); break;
                case Sister: activeTree.pushSisterToSet(targetPerson, person); break;
                case Son: activeTree.pushBrotherToSet(targetPerson, person); break;
                case Daughter: activeTree.pushSisterToSet(targetPerson, person); break;
            }
        }
    }

    public Person getPerson (String firstName, String lastName) {
        for (Person item: activeTree) {
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return item;
            }
        }
        return null;
    }

    public String getTreeInfo(){
        StringBuilder output = new StringBuilder();
        output.append("All records of Family Tree:" + "\n");
        output.append("##################################" + "\n");
        for (Person item: activeTree) {
            output.append(item + "\n");
        }
        output.append("---------------------------------" + "\n");
        return output.toString();
    }

//    public void sortByName(){
//        activeTree.sortByName();
//    }
//
//    public void sortByAge(){
//        activeTree.sortByAge();
//    }
}
