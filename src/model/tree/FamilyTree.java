package homeWork.src.model.tree;

import homeWork.src.model.builder.FamilyMemberBuilder;
import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.member.FamilyMemberComparatorByAge;
import homeWork.src.model.member.FamilyMemberCompareByBirthDate;
import homeWork.src.model.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree<M extends TreeItem<M>> implements Serializable, Iterable<M> {
    private long familyMemberId;
    private List<M> familyMembers;
    private FamilyMemberBuilder builder;
    public FamilyTree(){this(new ArrayList<>());}

    public FamilyTree(List<M> familyMembers){
        this.familyMembers = familyMembers;
        this.builder = new FamilyMemberBuilder();
    }

    public List<M> getFamilyMembers(){
        return familyMembers;
    }

    public boolean createFamilyMember(String name, String surname, String patronymicName, Gender gender,
                                      LocalDate birthDate, LocalDate deathDate,
                                      int motherID, int fatherID) {
        M member;
        M mother = getById(motherID);
        M father = getById(fatherID);

        // Explicitly cast mother and father to FamilyMember, the logic here is that FamilyMemberBuilder
        // class is used only to create a family tree for humans if I build a tree for dogs then I will
        // use a DogMemberBuilder

        FamilyMember castedMother = (FamilyMember) mother;
        FamilyMember castedFather = (FamilyMember) father;


        member = (M) builder.build(name, surname, patronymicName, gender,
                birthDate, deathDate, castedMother, castedFather);

        if (member!= null) {
            addFamilyMember(member);
        }
        return true;
    }

    public boolean addFamilyMember(M member) {
        if(member == null){
            return false;
        }
        if(!familyMembers.contains(member)){
            familyMembers.add(member);

            addToParents(member);
            addToChildren(member);
            return true;
        }
        return false;
    }

    private void addToParents(M member){
        for(M parent: member.getParents()){
            parent.addChild(member);
        }
    }

    private void addToChildren(M member){
        for(M child: member.getChildren()){
            child.addParent(member);
        }
    }

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

    public void save() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyMembers);
    }

    public void load() {
        FileHandler fileHandler = new FileHandler();
        List<M> loadedFamilyMembers = (List<M>) fileHandler.read();

        if (loadedFamilyMembers != null){
            familyMembers = loadedFamilyMembers;
        }

        builder.assignID(familyMembers);
        System.out.println(builder.getId());
    }

}