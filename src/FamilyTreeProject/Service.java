import java.util.List;

public class Service<T extends FamilyTreeObject>{
    private FamilyTree<T> familyTree;

    public Service(FamilyTree<T> familyTree){
        this.familyTree = familyTree;
    }
    public Service(){
        this (new FamilyTree<T>());
    }

    // public void addMember(Human human, Human mother, Human father){
    //     familyTree.addMember(human, mother, father);
    // }
    public Human createHuman(String firstName, String lastName, int dayOfBirth, int monthOfBirth,
    int yearOfBirth){
        return new Human(firstName, lastName, Gender.Male, dayOfBirth,
        monthOfBirth, yearOfBirth);
    }

    public void addMember(T human){
        familyTree.addMember(human);
    }

    public void addMember(String firstName, String lastName, int dayOfBirth, int monthOfBirth,
    int yearOfBirth){
        familyTree.addMember((T)createHuman(firstName, lastName, dayOfBirth,
        monthOfBirth, yearOfBirth));
    }

    public List<T> getAllMembers(){
        return familyTree.getAllMembers();  
    }

    public String getAllMembersAsString(){
        StringBuilder sb = new StringBuilder();
        for(T human: familyTree.getAllMembers()){
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<T> getMembersByName(String name){
        return familyTree.getMembersByName(name);
    }

    public String getMembersByNameAsString(String name){
        StringBuilder sb = new StringBuilder();
        for(T human: familyTree.getMembersByName(name)){
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
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
