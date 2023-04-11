package familyTree;

import familyTree.comparators.Group;
import member.Human;

import java.io.*;
import java.util.*;



public class FamilyTree<T extends FamilyMember> implements Group<T>, Iterable<T>, Serializable  {
    private T root;
    private Map<Integer, T> members;

    public FamilyTree() {
        this.root = null;
        this.members = new HashMap<>();
    }
    public FamilyTree(T root) {
        this.root = root;
    }

//    @Override
//    public boolean add(T member) {
//        if (members.containsKey(member.getId())) {
//            return false;
//        }
//        members.put(member.getId(), member);
//        if (member.getFather() != null) {
//            members.get(member.getFather().getId()).addChild(member);
//        }
//        if (member.getMother() != null) {
//            members.get(member.getMother().getId()).addChild(member);
//        }
//        if (member.getSiblings() != null) {
//            for (Human sibling : member.getSiblings()) {
//                members.get(sibling.getId()).addSibling(member);
//            }
//        }
//        if (member.getGrandparents() != null) {
//            for (Human grandparent : member.getGrandparents()) {
//                members.get(grandparent.getId()).addGrandchild(member);
//            }
//        }
//        if (member.getGrandchildren() != null) {
//            for (Human grandchild : member.getGrandchildren()) {
//                members.get(grandchild.getId()).addGrandparent(member);
//            }
//        }
//        return true;
//    }

    public boolean add(T member) {
        if (members.containsKey(member.getId())) {
            return false;
        }
        members.put(member.getId(), member);
        if (member instanceof Human) {
            Human human = (Human) member;
            if (human.getFather() != null) {
                members.get(human.getFather().getId()).addChild(human);
            }
            if (human.getMother() != null) {
                members.get(human.getMother().getId()).addChild(human);
            }
            if (human.getSiblings() != null) {
                for (Human sibling : human.getSiblings()) {
                    members.get(sibling.getId()).addSibling(human);
                }
            }
            if (human.getGrandparents() != null) {
                for (Human grandparent : human.getGrandparents()) {
                    members.get(grandparent.getId()).addGrandchild(human);
                }
            }
            if (human.getGrandchildren() != null) {
                for (Human grandchild : human.getGrandchildren()) {
                    members.get(grandchild.getId()).addGrandparent(human);
                }
            }
        }
        return true;
    }

    public T getRoot() {
        return root;
    }

    @Override
    public boolean remove(T member) {
        if (!members.containsKey(member.getId())) {
            return false;
        }
        for (FamilyMember child : member.getChildren()) {
            child.setFather(null);
            child.setMother(null);
        }
        for (FamilyMember sibling : member.getSiblings()) {
            sibling.getSiblings().remove(member);
        }
        for (Human grandparent : member.getGrandparents()) {
            grandparent.getGrandchildren().remove(member);
        }
        for (Human grandchild : member.getGrandchildren()) {
            grandchild.getGrandparents().remove(member);
        }
        members.remove(member.getId());
        return true;

    }

    @Override
    public List<T> getMembers() {
        return new ArrayList<>(members.values());
    }


//    public void setRoot(T root) {
//        this.root = root;
//    }

    @Override
    public void setRoot(T root) {
        if (root == null) {
            throw new IllegalArgumentException("Head cannot be null");
        }
        if (this.root != null) {
            throw new IllegalStateException("Head is already set");
        }
        this.root = root;
        add(root);
    }

    public T getMemberById(int id) {
        return members.get(id);
    }


    public List<T> searchByName(String name, String surname) {
        List<T> result = new ArrayList<>();
        for (T member : members.values()) {
            if (member.getName().equals(name) && member.getSurname().equals(surname)) {
                result.add(member);
            }
        }
        return result;
    }

    public List<T> searchBySurname(String surname) {
        List<T> result = new ArrayList<>();
        for (T member : members.values()) {
            if (member.getSurname().equals(surname)) {
                result.add(member);
            }
        }
        return result;
    }



//    public E getByName(String name) {
//        for (E human :
//                humanList) {
//            if (human.getClass().getName().equals(name))
//                return human;
//        }
//        return null;
//    }
//    public E getBySurname(String surname) {
//        for (E human :
//                humanList) {
//            if (human.getClass().getSurname().equals(surname))
//                return human;
//        }
//        return null;
//    }
//    public void addHuman(T member) {
//        members.put(member);
//    }


//    public boolean add(E human) {
//        if (human == null) {
//            return false;
//        }
//        if (!humanList.contains(human)) {
//            humanList.add(human);
//            if (human.getFather() != null) {
//                human.getFather().addChild(human);
//            }
//            if (human.getMother() != null) {
//                human.getMother().addChild(human);
//            }
//            return true;
//        }
//        return false;
//    }

    public Map<String, Object> getFamilyTreeInfo() {
        Map<String, Object> familyTreeInfo = new HashMap<>();
        familyTreeInfo.put("head", root);
        familyTreeInfo.put("members", members);
        return familyTreeInfo;
    }

    public String getInfo() {
        StringBuilder tree = new StringBuilder();
        tree.append("В дереве ").append(members.size())
                .append(" объектов").append(" \n");
        for (T member: members.values()) {
            tree.append(member.getInfo()).append("\n");
        }
        return tree.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new MemberIterator<>(root);
    }

//    @Override
//    public Iterator<T> iterator() {
//        return members.values().iterator();
//    }


}
