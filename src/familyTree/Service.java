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


    public String printTree(){
//        System.out.println(tree.getInfo());
        return tree.getInfo();
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

    public T searchMemberByName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым.\n");
            }
            for (T member : tree.getMembers()) {
                if (member.getName().equalsIgnoreCase(name.trim())) {
                    return member;
                }
            }
            throw new IllegalArgumentException("Человек с именем '" + name + "' не найден в дереве.\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String searchMember(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым.");
            }
            for (T member : tree.getMembers()) {
                if (member.getName().equalsIgnoreCase(name.trim())) {
                    return member.getInfo();
                }
            }
            throw new IllegalArgumentException("Человек с именем '" + name + "' не найден в дереве.");
        } catch (IllegalArgumentException e) {
            return "Ошибка: " + e.getMessage() + " Пожалуйста, проверьте правильность введенных данных и попробуйте еще раз.";
        }
    }

    public void removeMember(String name) {
        if (tree.getMembers().isEmpty()) {
            System.out.println("Дерево пустое.");
            return;
        }
        T memberToRemove = null;
        for (T member : tree.getMembers()) {
            if (member.getName().equalsIgnoreCase(name.trim())) {
                memberToRemove = member;
                break;
            }
        }
        if (memberToRemove == null) {
            System.out.println("Человек с именем '" + name + "' не найден в дереве.");
            return;
        }
        if (memberToRemove.getChildren().size() > 0) {
            System.out.println("Невозможно удалить человека, у которого есть дети.");
            return;
        }
        tree.remove(memberToRemove);
        System.out.println("Человек с именем '" + name + "' удален из дерева.");
    }



}
