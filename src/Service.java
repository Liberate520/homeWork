import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Service {
    private int id;
    private FamilyTree familyTree;
    private List<FamilyTree> familyTreeList;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(familyTree);

    }

    public Service() {
        this(new FamilyTree());
    }

    public void addHuman(String firstName,String lastName,Gender gender,String dateOfBirth){
        familyTree.addHumanOfFamilyTree(new Human(id++,firstName,lastName,gender,dateOfBirth));
    }

    public void addHumanList(FamilyTree familyTree){
        familyTreeList.add(familyTree);
    }


    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: familyTree ){
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public Human searchByName(String find) {
        for (Human human : familyTree) {
            if (human.getFirstName().equals(find)) {
                return human;
            }
        }
        return null;
    }

    public Human searchByID(int find) {
        for (Human human : familyTree) {
            if (human.getId()==find) {
                return human;
            }
        }
        return null;
    }

    public void PrintBirthdaySort (){
        Set<Human> humanSet = new TreeSet<Human>(new HumanBirthdayComporator());
        for (Human human: familyTree)
        {
            humanSet.add(human);
        }

        for (Human human: humanSet){
            System.out.println(human.toString());
        }
    }

    public void PrintFirstNameSort(){
        Set<Human> humanSet = new TreeSet<>(new HumanNameComporator());
        for (Human human:familyTree
             ) {
            humanSet.add(human);
        }
        for (Human human: humanSet){
            System.out.println(human.toString());
        }
    }



}
