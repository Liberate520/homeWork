import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service(FamilyTree<Human> familyTree){
        this.familyTree = familyTree;
    }
    public Service(){
        this (new FamilyTree<Human>());
    }

    // public void addMember(Human human, Human mother, Human father){
    //     familyTree.addMember(human, mother, father);
    // }
    public void addMember(Human human){
        familyTree.addMember(human);
    }

    public List<Human> getAllMembers(){
        return familyTree.getAllMembers();  
    }
    public List<Human> getMembersByName(String name){
        return familyTree.getMembersByName(name);
    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByAge(){
        familyTree.sortByAge();
    }
    // public void sort(){
    //     familyTree.sort();
    // }
}
