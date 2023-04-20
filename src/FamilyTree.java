import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    
    private List<Human> familyMembers;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> familyMembers){
        this.familyMembers = familyMembers;
    }

    public List<Human> getAllMembers(){
        return familyMembers;
    }

    public List<Human> getMembersByName(String name){
        List<Human> res = new ArrayList<>();
        for (int i = 0; i < familyMembers.size(); i++) {
            if (familyMembers.get(i).getFullName().indexOf(name)>=0){
                res.add(familyMembers.get(i));
            }
        }
        return res;
    }
}
