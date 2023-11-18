package homeWork.src.service;

import homeWork.src.builder.FamilyMemberBuilder;
import homeWork.src.member.FamilyMember;
import homeWork.src.tree.FamilyTree;
import homeWork.src.tree.Gender;
import homeWork.src.tree.TreeItem;
import java.time.LocalDate;

public class Service<M extends TreeItem<M>> {

    private FamilyTree<M> newTree;
    private FamilyMemberBuilder builder;
    private M member;

    public Service(){
        newTree = new FamilyTree<>();
        builder = new FamilyMemberBuilder();
    }

    private boolean addFamilyMember(M member) {
//        newTree.addFamilyMember(member);
        if(member == null){
            return false;
        }
        if(!newTree.getFamilyMembers().contains(member)){
            newTree.addFamilyMember(member);
//            member.setId(familyMemberId++);

            addToParents(member);
            addToChildren(member);
            return true;
        }
        return false;
//        return true;
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

    public FamilyMember createFamilyMember(String name, String surname, String patronymicName, Gender gender,
                                   LocalDate birthDate, LocalDate deathDate,
                                           M mother, M father) {
        FamilyMember member;
        if(deathDate == null && father == null && mother == null) {
            member = builder.build(name, surname, patronymicName, gender,
                    birthDate);
        } else if (father == null && mother == null){
            member = builder.build(name, surname, patronymicName, gender,
                    birthDate, deathDate);
        } else if (deathDate == null){
            member = builder.build(name, surname, patronymicName, gender,
                    birthDate, null,null,null);
        } else {
            return null;
        }

        if (member!= null) {
            addFamilyMember((M) member);
        }
        return member;
    }

    public FamilyTree<M> getFamilyTree(){
        return newTree;
    }

    public String getFamilyTreeInfo(FamilyTree<M> tree){
        return tree.getInfo();
    }

    public boolean setWedding(M m1, M m2){
        return newTree.setWedding(m1, m2);
    }

    public boolean setWedding(long m1ID, long m2ID){
        return newTree.setWedding(m1ID, m2ID);
    }

    public void sortBySurname(FamilyTree<M> tree){
        tree.sortBySurname();
    }

    public void sortByAge(FamilyTree<M> tree){
        tree.sortByAge();
    }

    public void sortByBirthDate(FamilyTree<M> tree){
        tree.sortByBirthDate();
    }

    public boolean addChild(M member, M child){
        return member.addChild(child);
    }

}
