import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class GenealogicalTree implements Serializable {
    private List<Human> familyList;

    public void save(){
        FileHandler.write();
    }

    public void read(){
        FileHandler.read("myTree.txt");
    }

    public void addMember(Human member){
        familyList.add(member);
        if (!member.getFather().equals(null)){
            member.getFather().addChild(member);
            member.getMother().addChild(member);
        }
    }

    public List searchName (String name){
        List<Human> findingPersons = new List<Human>();
        for (Human human : familyList) {
            if (human.getName().equals(name)){
                findingPersons.add(human);
            }
        }
        return findingPersons;
    }
}


