package homeWork.src.tree;

import homeWork.src.member.FamilyMember;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long familyMemberId;
    private List<FamilyMember> familyMembers;

    public FamilyTree(){this(new ArrayList<>());}

    public FamilyTree(List<FamilyMember> familyMembers){
        this.familyMembers = familyMembers;
    }

    public void addFamilyMember(FamilyMember member){
        familyMembers.add(member);
    }

    public boolean add(FamilyMember member){
        if(member == null){
            return false;
        }
        if(!familyMembers.contains(member)){
            familyMembers.add((member));
            member.setId(familyMemberId++);

            addToParents(member);
            addToChildren(member);
            return true;
        }
        return false;
    }

    public FamilyMember getById(long id){
        if(!checkId(id)){
            return null;
        }
        for(FamilyMember member: familyMembers){
            if(member.getId() == id){
                return member;
            }
        }
        return null;
    }

    public List<FamilyMember> getSiblins(int id){
        FamilyMember member = getById(id);
        if(member == null){
            return null;
        }
        List<FamilyMember> result = new ArrayList<>();
        for (FamilyMember parent: member.getParents()){
            for (FamilyMember child: parent.getChildren()){
                if(!child.equals(member) && !result.contains(child)){
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<FamilyMember> getByName (String name){
        List<FamilyMember> result = new ArrayList<>();
        for(FamilyMember member: familyMembers){
            if(member.getName().contains(name)){
                result.add(member);
            }
        }
        return result;
    }

    public boolean setWedding(long memberId1, long memberId2){
        if(checkId(memberId1) && checkId(memberId2)) {
            FamilyMember member1 = getById(memberId1);
            FamilyMember member2 = getById(memberId2);
            return setWedding(member1, member2);
        }
        return false;
    }

    public boolean setWedding(FamilyMember member1, FamilyMember member2){
        if(member1.getSpouse() == null && member2.getSpouse() == null){
            member1.setSpouse(member2);
            member2.setSpouse(member1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(FamilyMember e1, FamilyMember e2){
        if(e1.getSpouse() != null && e2.getSpouse() != null){
            e1.setSpouse(null);
            e2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long eId){
        if(checkId(eId)){
            FamilyMember member = getById(eId);
            return familyMembers.remove(member);
        }
        return false;
    }

    private void addToParents(FamilyMember member){
        for(FamilyMember parent: member.getParents()){
            parent.addChild(member);
        }
    }

    private void addToChildren(FamilyMember member){
        for(FamilyMember child: member.getChildren()){
            child.addParent(member);
        }
    }

    private boolean checkId(long id){
        return id < familyMemberId && id >= 0;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("In the tree ");
        sb.append(familyMembers.size());
        sb.append(" objects: \n");
        for(FamilyMember member: familyMembers){
            sb.append(member);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}