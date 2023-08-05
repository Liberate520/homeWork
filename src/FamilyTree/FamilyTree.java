package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyMembers = new ArrayList<>();
    private int counter;
    private String name;

    public FamilyTree(String name, List<Human> members) {
        this.name = name;
        for (counter = 0; counter < members.size(); counter++) {
            members.get(counter).setId(counter);
            this.familyMembers.add(members.get(counter));
        }
    }

    public FamilyTree(String name, Human member) {
        this(name, Arrays.asList(member));
    }

    public String ShowAllTree() {
        StringBuilder representation = new StringBuilder();
        for (int i = 0; i < this.familyMembers.size(); i++) {
            representation.append(String.format("id:%s name:%s\n", familyMembers.get(i).getId(), familyMembers.get(i)));
        }
        return representation.toString();
    }

    public void addMember(Human newMember){
        newMember.setId(counter);
        this.counter += 1;
        this.familyMembers.add(newMember);
    }

    public void addMember(Human newMember, List<Integer> childrenIds){
        Gender memberGender = newMember.getGender();
        for (int i = 0; i < childrenIds.size(); i++){
            newMember.addChild(this.familyMembers.get(childrenIds.get(i)));
            if (memberGender == Gender.Female){
                this.familyMembers.get(childrenIds.get(i)).setMother(newMember);
            }
            if (memberGender == Gender.Male){
                this.familyMembers.get(childrenIds.get(i)).setFather(newMember);
            }
        }
        this.addMember(newMember);
    }



    public void addChild(int parentId, int childId){
        Gender parentGender = this.familyMembers.get(parentId).getGender();
        if (parentGender == Gender.Male){
            this.familyMembers.get(childId).setFather(this.familyMembers.get(parentId));
        }
        if (parentGender == Gender.Female){
            this.familyMembers.get(childId).setMother(this.familyMembers.get(parentId));
        }
        this.familyMembers.get(parentId).addChild(this.familyMembers.get(childId));
    }

    public String memberFullInfo(int id){
        return this.familyMembers.get(id).getFullInfo();
    }
}
