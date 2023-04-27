import human.Gender;
import human.Human;
import familyTree.FamilyTree;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree activeFamilyTree;
    private List<FamilyTree> familyTreeList;

    public Service(FamilyTree familyTree){
        this.activeFamilyTree = familyTree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(familyTree);
    }
    public Service(){
        this(new FamilyTree());
    }

    public void addFamilyTree(FamilyTree familyTree){
        familyTreeList.add(familyTree);
    }
    public void writeFamilyTreeToFile(String fileName){
        activeFamilyTree.saveToFile(fileName);
    }
    public void readFamilyTreeFromFile(String fileName){
        try {
            activeFamilyTree.readFromFile(fileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void addHuman(String firstName, String lastName, String birthday, Gender gender, Human mother, Human father){
        activeFamilyTree.addHuman(new Human(id++, firstName, lastName,birthday,gender,mother,father));
    }

    public String getInfo(){
        String family = activeFamilyTree.getPeople();
        if (family.isEmpty()){
            return null;
        }
        return family;
    }
    public Human getHuman(String firstName, String lastName, String birthday){
        return activeFamilyTree.getHuman(firstName, lastName, birthday);
    }

    public void sortByFirstName(){
        activeFamilyTree.sortByFirstName();

    }public void sortByLastName(){
        activeFamilyTree.sortByLastName();
    }
    public void sortById(){
        activeFamilyTree.sortById();
    }

    public void sortByNumberOfChildren(){
        activeFamilyTree.sortByNumberOfChildren();
    }

    public void IdentifyChildren(int parentId){
        activeFamilyTree.IdentifyChildren(activeFamilyTree.getHumanById(parentId));
    }
    public void setFather(Human father, Human child){
        child.setFather(father);
        father.setChildren(child);

    }
    public void setMother(Human mother, Human child){
        child.setFather(mother);
        mother.setChildren(child);
    }
    public Human getHumanById(int id){
        return activeFamilyTree.getHumanById(id);
    }

}
