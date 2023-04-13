package familyTree;

import familyTree.comparators.MemberComparatorByBirthday;
import familyTree.comparators.MemberComparatorByName;
import familyTree.comparators.ByNumberChildComparator;
import familyTree.member.FamilyMember;
import familyTree.member.Gender;
import familyTree.member.Human;
import service.FileHandler;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Service<T extends FamilyMember> {
    private int id;
    private FamilyTree<T> tree;
    private FileHandler handler;

    public Service(FamilyTree<T> tree) {
        this.tree = tree;
    }
    public FamilyTree<T> getTree() {
        return tree;
    }
    public FileHandler getHandler() {
        return handler;
    }
    public void setTree(FamilyTree<T> tree) {
        this.tree = tree;
    }
    public void setHandler(FileHandler handler) {
        this.handler = handler;
    }
    public void addHuman(String name, String surname, Gender gender, String dateBirth, Human father, Human mother) {

        tree.add((T) new Human(id++, name, surname, gender, dateBirth, father, mother));
    }


    public void addHuman(String name, String surname, Gender gender, String dateBirth) {

        tree.add((T) new Human(id++, name, surname, gender, dateBirth));
    }
    public void printTree(){
        System.out.println(tree.getInfo());
    }

    public void printTrees(){
        tree.printTree();
    }

    public void save(String fileName){
        if (handler != null && tree != null) {
            try {
                handler.write(tree, fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void load(String fileName) {
        if (handler != null) {
            try {
                tree = (FamilyTree<T>) handler.read(fileName);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void sortByName () {
        tree.getMembers().sort((Comparator<? super T>) new MemberComparatorByName());
    }


    public void sortByBirthday () {
        tree.getMembers().sort((Comparator<? super T>) new MemberComparatorByBirthday());
    }

    public void sortByNumChild () {
        tree.getMembers().sort((Comparator<? super T>) new ByNumberChildComparator());
    }

    public void clearTree() {
        List<T> members = tree.getMembers();
        members.clear();
        tree.setMembers(members);

    }
    public String getHumanByName(String name) {
        List<T> members = tree.getMembers();
        String memberName = null;
        T person = null;
        for (T member: members) {
            if(member.getName().equals(name)) {
                memberName = member.getName();
                person = member;
            }

        }
        return memberName + ", отец: " + person.getFather() + ", мать: " + person.getMother()
                + ", дети: " + person.getChildren() + ", братья и сёстры: " + person.getSiblings();
    }

    public String findHuman(String name) {
        for (T member: tree) {
            if (member.getName().equals(name)) {
                return member.getInfo();
            }
        }
        return "Человек с таким именем не найден";
    }

    public T searchMemberByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        for (T member : tree.getMembers()) {
            if (member.getName().equalsIgnoreCase(name.trim())) {
                return member;
            }
        }
        throw new IllegalArgumentException("Человек с именем '" + name + "' не найден в дереве.");
    }

    public void removeMember(String name) {
        for (T member: tree) {
            if (member.getName().equals(name)) {
                tree.remove(member);
            }
        }
        System.out.println("Человек с таким именем не найден");
    }



}
