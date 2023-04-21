import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    
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

    public void addMember(Human human, Human mother, Human father){
        if(!familyMembers.contains(human)){
            familyMembers.add(human);
            if(mother!=null){
                human.setMother(mother);
                if(!mother.getChildren().contains(human)){
                    mother.addChild(human);
                }
               }
            if(father!=null){
               human.setFather(father);
               if(!father.getChildren().contains(human)){
                    father.addChild(human);
                }
            }
            }
        }
    }
