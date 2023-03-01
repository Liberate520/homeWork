import java.util.List;

public class GenealogicalTree {
    private List<Human> familyList;
    private List<Human> findingPersons;

    public void addMember(Human memeber){
        familyList.add(memeber);
    }

    public List searchName (String name){
        for (Human human : familyList) {
            if (human.getName().equals(name)){
                findingPersons.add(human);
            }
        }
        return findingPersons;
    }
}


