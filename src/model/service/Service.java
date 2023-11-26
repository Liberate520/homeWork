package homeWork.src.model.service;

import homeWork.src.model.builder.FamilyMemberBuilder;
import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.tree.FamilyTree;
import homeWork.src.model.tree.Gender;
import homeWork.src.model.tree.TreeItem;
import homeWork.src.model.writer.FileHandler;

import java.time.LocalDate;

public class Service {

    private FamilyTree<FamilyMember> newTree;
//    private M member;

    public Service(){
        newTree = new FamilyTree<>();
    }

    private void addFamilyMember(FamilyMember member) {
        newTree.addFamilyMember(member);
////        newTree.addFamilyMember(member);
//        if(member == null){
//            return false;
//        }
//        // Это внутренняя часть дерева и метод get не может изменяться без разрешения дерева
//        // (признак нарушения: слишком много строчек). Пример: кассир берет деньги из вашего кошелька.
//        // Решение: вынести данную работу в класс FamilyTree.
//        if(!newTree.getFamilyMembers().contains(member)){
//            newTree.addFamilyMember(member);
////            member.setId(familyMemberId++);
//
//            addToParents(member);
//            addToChildren(member);
//            return true;
//        }
//        return false;
////        return true;
    }

    // Add parents так же перенести в класс FamilyTree
//    private void addToParents(FamilyMember member){
//        for(FamilyMember parent: member.getParents()){
//            parent.addChild(member);
//        }
//    }
//
//    private void addToChildren(FamilyMember member){
//        for(FamilyMember child: member.getChildren()){
//            child.addParent(member);
//        }
//    }

//    public boolean createFamilyMember(String name, String surname, String patronymicName, Gender gender,
//                                           LocalDate birthDate, LocalDate deathDate,
//                                           int motherID, int fatherID) {
//        FamilyMember member;
//        FamilyMember mother = newTree.getById(motherID);
//        FamilyMember father = newTree.getById(fatherID);
//
//        member = builder.build(name, surname, patronymicName, gender,
//                birthDate, deathDate, mother, father);
//
//        if (member!= null) {
//            addFamilyMember(member);
//        }
//        return true;
//    }

    public void createFamilyMember(String name, String surname, String patronymicName, Gender gender,
                                           LocalDate birthDate, LocalDate deathDate,
                                           int motherID, int fatherID){
        newTree.createFamilyMember(name, surname, patronymicName, gender, birthDate, deathDate, motherID, fatherID);
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

    public void sortBySurname(FamilyTree<FamilyMember> tree){
        tree.sortBySurname();
    }

    public void sortByAge(FamilyTree<FamilyMember> tree){
        tree.sortByAge();
    }

    public void sortByBirthDate(FamilyTree<FamilyMember> tree){
        tree.sortByBirthDate();
    }

    public boolean addChild(FamilyMember member, FamilyMember child){
        return member.addChild(child);
    }

    // Путь нужно вынести в filehandler
//    public FamilyTree<FamilyMember> loadFamilyTree(){
//        FileHandler fileHandler = new FileHandler();
//        String filePath = "src/homeWork/src/model/writer/tree.txt";
//        newTree = (FamilyTree<FamilyMember>) fileHandler.read();
//        builder.assignID(newTree);
//        return newTree;
//    }

    public FamilyTree<FamilyMember> loadTree(){
        newTree.load();
        return newTree;
    }

    public void save(){
        newTree.save();
    }
}
