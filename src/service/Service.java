package homeWork.src.service;

import homeWork.src.builder.FamilyMemberBuilder;
import homeWork.src.member.FamilyMember;
import homeWork.src.tree.FamilyTree;
import homeWork.src.tree.Gender;

import java.time.LocalDate;

public class Service {

    private FamilyTree newTree;
    private FamilyMemberBuilder builder;
    private FamilyMember member;

    public Service(){
        newTree = new FamilyTree();
        builder = new FamilyMemberBuilder();
    }

    private boolean addFamilyMember(FamilyMember member) {
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

    public FamilyMember createFamilyMember(String name, String surname, String patronymicName, Gender gender,
                                   LocalDate birthDate, LocalDate deathDate,
                                           FamilyMember mother, FamilyMember father) {
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
            addFamilyMember(member);
        }
        return member;
    }

    public FamilyTree getFamilyTree(){
        return newTree;
    }

    public String getFamilyTreeInfo(FamilyTree tree){
        return tree.getInfo();
    }

    public boolean setWedding(FamilyMember m1, FamilyMember m2){
        return newTree.setWedding(m1, m2);
    }

    public boolean setWedding(long m1ID, long m2ID){
        return newTree.setWedding(m1ID, m2ID);
    }

    public void sortBySurname(FamilyTree tree){
        tree.sortBySurname();
    }

    public void sortByAge(FamilyTree tree){
        tree.sortByAge();
    }

    public void sortByBirthDate(FamilyTree tree){
        tree.sortByBirthDate();
    }

    public boolean addChild(FamilyMember member, FamilyMember child){
        return member.addChild(child);
    }

}
