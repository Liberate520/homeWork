package familyTree;

import familyTree.comparators.Group;
import familyTree.member.FamilyMember;
import familyTree.member.Human;

import java.io.*;
import java.util.*;



public class FamilyTree<T extends FamilyMember> implements Group<T>, Iterable<T>, Serializable  {
    //private T root;
    private List<T> members;

//    public FamilyTree(T root) {
//        this.root = root;
//        this.members = new ArrayList<>();
//        this.members.add(root);
//    }

    public FamilyTree() {
        //this.root = null;
        this.members = new ArrayList<>();
    }

//    public T getRoot() {
//        return root;
//    }

    public void setMembers(List<T> members) {
        this.members = members;
    }

//    public <T extends FamilyMember> void setMembers(List<T> members) {
//        this.members = members;
//    }

    @Override
    public boolean add(T member) {
        if (members.contains(member)) {
            return false;
        }
        members.add(member);
        if (member.getFather() != null) {
            member.getFather().addChild((Human) member);
        }
        if (member.getMother() != null) {
            member.getMother().addChild((Human) member);
        }
        if (member.getSiblings() != null) {
            for (Human sibling : member.getSiblings()) {
                ((T) sibling).addSibling((Human) member);
            }
        }
        if (member.getGrandparents() != null) {
            for (Human grandparent : member.getGrandparents()) {
                ((T) grandparent).addGrandchild((Human) member);
            }
        }
        if (member.getGrandchildren() != null) {
            for (Human grandchild : member.getGrandchildren()) {
                ((T) grandchild).addGrandparent((Human) member);
            }
        }
        return true;
    }

    @Override
    public boolean remove(T member) {
        if (!members.contains(member)) {
            return false;
        }
        for (Human child : member.getChildren()) {
            child.setFather(null);
            child.setMother(null);
        }
        for (Human sibling : member.getSiblings()) {
            ((T) sibling).getSiblings().remove(member);
        }
        for (Human grandparent : member.getGrandparents()) {
            ((T) grandparent).getGrandchildren().remove(member);
        }
        for (Human grandchild : member.getGrandchildren()) {
            ((T) grandchild).getGrandparents().remove(member);
        }
        members.remove(member);
        return true;
    }
    @Override
    public List<T> getMembers() {
        return new ArrayList<>(members);
    }

//    @Override
//    public void setRoot(T root) {
//        if (root == null) {
//            throw new IllegalArgumentException("Root cannot be null");
//        }
//        if (this.root != null) {
//            throw new IllegalStateException("Root is already set");
//        }
//        this.root = root;
//        add(root);
//    }

    public T getMemberById(int id) {
        return members.get(id);
    }

    public List<T> searchByName(String name, String surname) {
        List<T> result = new ArrayList<>();
        for (T member : members) {
            if (member.getName().equals(name) && member.getSurname().equals(surname)) {
                result.add(member);
            }
        }
        return result;
    }

    public List<T> searchBySurname(String surname) {
        List<T> result = new ArrayList<>();
        for (T member : members) {
            if (member.getSurname().equals(surname)) {
                result.add(member);
            }
        }
        return result;
    }

    public T getByName(String name) {
        for (T member :
                members) {
            if (member.getName().equals(name))
                return member;
        }
        return null;
    }

    public void printTree() {
        for (T member : members) {
            System.out.println(member);
            if (member.getFather() != null) {
                System.out.println("отец: " + member.getFather());
            }
            if (member.getMother() != null) {
                System.out.println("мать: " + member.getMother());
            }
            if (member.getChildren() != null) {
                System.out.println("дети: ");
                for (Human child : member.getChildren()) {
                    System.out.println(child);
                }
            }
            if (member.getSiblings() != null) {
                System.out.println("братья и сестры: ");
                for (Human sibling : member.getSiblings()) {
                    System.out.println(sibling);
                }
            }
            if (member.getGrandparents() != null) {
                System.out.println("бабушки и дедушки: ");
                for (Human grandparent : member.getGrandparents()) {
                    System.out.println(grandparent);
                }
            }
            if (member.getGrandchildren() != null) {
                System.out.println("внуки: ");
                for (Human grandchild : member.getGrandchildren()) {
                    System.out.println(grandchild);
                }
            }
            System.out.println();
        }
    }


    public String getInfo() {
        StringBuilder tree = new StringBuilder();
        tree.append("В дереве ").append(members.size())
                .append(" объектов").append(" \n");
        for (T member: members) {
            tree.append(member.getInfo()).append("\n");
        }
        return tree.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new MemberIterator<>(members);
    }



}
