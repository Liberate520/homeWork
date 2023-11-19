package homeWork.src.model.tree;

import homeWork.src.model.member.FamilyMemberComparatorByAge;
import homeWork.src.model.member.FamilyMemberCompareByBirthDate;
import java.io.Serializable;
import java.util.*;

public class FamilyTree<M extends TreeItem<M>> implements Serializable, Iterable<M> {
    private long familyMemberId;
    private List<M> familyMembers;

    public FamilyTree(){this(new ArrayList<>());}

    public FamilyTree(List<M> familyMembers){
        this.familyMembers = familyMembers;
    }

    public void addFamilyMember(M member){
        familyMembers.add(member);
    }

    public List<M> getFamilyMembers(){
        return familyMembers;
    }

//    public boolean add(T member){
//        if(member == null){
//            return false;
//        }
//        if(!familyMembers.contains(member)){
//            familyMembers.add((member));
//            member.setId(familyMemberId++);
//
//            addToParents(member);
//            addToChildren(member);
//            return true;
//        }
//        return false;
//    }

    public M getById(long id){
        if(!checkId(id)){
            return null;
        }
        for(M member: familyMembers){
            if(member.getId() == id){
                return member;
            }
        }
        return null;
    }

    public List<M> getSiblins(int id){
        M member = getById(id);
        if(member == null){
            return null;
        }

        List<M> result = new ArrayList<>();
        for (M parent: member.getParents()){
            for (M child: parent.getChildren()){
                if(!child.equals(member) && !result.contains(child)){
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<M> getByName (String name){
        List<M> result = new ArrayList<>();
        for(M member: familyMembers){
            if(member.getName().contains(name)){
                result.add(member);
            }
        }
        return result;
    }

    public boolean setWedding(long memberId1, long memberId2){
        if(checkId(memberId1) && checkId(memberId2)) {
            M member1 = getById(memberId1);
            M member2 = getById(memberId2);
            return setWedding(member1, member2);
        }
        return false;
    }

    public boolean setWedding(M member1, M member2){
        if(member1.getSpouse() == null && member2.getSpouse() == null){
            member1.setSpouse(member2);
            member2.setSpouse(member1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(M e1, M e2){
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
            M member = getById(eId);
            return familyMembers.remove(member);
        }
        return false;
    }

//    private void addToParents(T member){
//        for(T parent: member.getParents()){
//            parent.addChild(member);
//        }
//    }

//    private void addToChildren(T member){
//        for(T child: member.getChildren()){
//            child.addParent(member);
//        }
//    }

    private boolean checkId(long id){
        return id < familyMemberId && id >= 0;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("In the tree ");
        sb.append(familyMembers.size());
        sb.append(" objects: \n");
        for(M member: familyMembers){
            sb.append(member);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public void sortBySurname (){
        Collections.sort(familyMembers);
    }

    public void sortByAge (){
//        Collections.sort(familyMembers, new FamilyMemberComparatorByAge());
        familyMembers.sort(new FamilyMemberComparatorByAge<>());
    }

    public void sortByBirthDate(){
        familyMembers.sort(new FamilyMemberCompareByBirthDate<>());
    }

    @Override
    public Iterator<M> iterator() {
        return new FamilyMemberIterator<>(familyMembers);
    }

}