package homeWork.src.model.service;

import homeWork.src.model.builder.FamilyMemberBuilder;
import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.tree.DateBuilder;
import homeWork.src.model.tree.FamilyTree;
import homeWork.src.model.tree.Gender;
import homeWork.src.model.writer.FileHandler;
import homeWork.src.model.writer.Writable;

import java.time.LocalDate;
import java.util.Scanner;

public class Service {

    private FamilyTree<FamilyMember> newTree;
//    Scanner scanner = new Scanner(System.in);
    private FamilyMemberBuilder builder;
    Writable writable;

    public Service(){
        builder = new FamilyMemberBuilder();
        newTree = new FamilyTree<>();
        writable = new FileHandler();
    }


    private void addFamilyMember(FamilyMember member) {
        newTree.addFamilyMember(member);
    }

    public void createFamilyMember(String name, String surname, String patronymicName, Gender gender,
                                           LocalDate birthDate, LocalDate deathDate,
                                           int motherID, int fatherID){
        FamilyMember mother = newTree.getById(motherID);
        FamilyMember father = newTree.getById(fatherID);
        FamilyMember member = builder.build(name, surname, patronymicName, gender, birthDate, deathDate, mother, father);
        newTree.addFamilyMember(member);
    }

    public FamilyTree<FamilyMember> getFamilyTree(){
        return newTree;
    }

    public String getFamilyTreeInfo(){
        return newTree.getInfo();
    }

    public boolean setWedding(FamilyMember m1, FamilyMember m2){
        return newTree.setWedding(m1, m2);
    }

    public boolean setWedding(long m1ID, long m2ID){
        return newTree.setWedding(m1ID, m2ID);
    }

    public void sortBySurname(){
        newTree.sortBySurname();
    }

    public void sortByAge(FamilyTree<FamilyMember> tree){
        tree.sortByAge();
    }

    public void sortByBirthDate(){
        newTree.sortByBirthDate();
    }

    public boolean addChild(FamilyMember member, FamilyMember child){
        return member.addChild(child);
    }

    public void addChild(long memberID, long childID){
        FamilyMember member = newTree.getById(memberID);
        FamilyMember child = newTree.getById(childID);
        member.addChild(child);
    }

    public void loadTree(){
        newTree = (FamilyTree<FamilyMember>) writable.read();
        builder.assignID(newTree.getFamilyMembers());
    }

    public void save(){
        writable.save(newTree);
    }

    public void changeName(long familyMemberID, String name){
        FamilyMember member = newTree.getById(familyMemberID);
        member.setName(name);
        System.out.println(member);
    }

    public void changeSurname(long familyMemberID, String surname){
        FamilyMember member = newTree.getById(familyMemberID);
        member.setSurname(surname);
        System.out.println(member);
    }

    public void changePatronymicName(long familyMemberID, String patronymicName){
        FamilyMember member = newTree.getById(familyMemberID);
        member.setPatronymicName(patronymicName);
        System.out.println(member);
    }

    public void chnageGender(long familyMemberId, String gender){
        FamilyMember member = newTree.getById(familyMemberId);
        member.setGender(gender);
        System.out.println(member);
    }

    public void changeBirthDate(FamilyMember member){
        DateBuilder dtBuilder = new DateBuilder();
        member.setBirthDate(dtBuilder.buildDate());
    }

    public void changeDeathDate(FamilyMember member){
        DateBuilder dtBuilder = new DateBuilder();
        member.setDeathDate(dtBuilder.buildDate());
    }

    public void changeSpouse(long familyMemberID, long spouseID){
        setWedding(familyMemberID, spouseID);
        System.out.println(getFamilyTreeInfo());
    }

    public void changeMother(long familyMemberID, long motherID){
        FamilyMember member = newTree.getById(familyMemberID);
        FamilyMember mother = newTree.getById(motherID);
        member.setMother(mother);
        System.out.println(member);
    }

    public void changeFather(long familyMemberID, long fatherID){
        FamilyMember member = newTree.getById(familyMemberID);
        FamilyMember father = newTree.getById(fatherID);
        member.setFather(father);
        System.out.println(member);
    }

    public String getName(FamilyMember member) {
        return member.getName();
    }

    public FamilyMember getFamilyMember(long id) {
        FamilyMember member = newTree.getById(id);
        return member;
    }
}
