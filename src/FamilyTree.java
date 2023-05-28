import java.util.*;

public class FamilyTree {
    private static Map<Human, FamilyTreeMember> allMembers = new HashMap<>();
    private final String familyName;
    private Set<FamilyTreeMember> members = new HashSet<>();

    public FamilyTree(String name) {
        this.familyName = name;
    }
    public FamilyTree(String name, Human human) {
        this.familyName = name;
        this.add(human);
    }

    /**
     * Create familyTreeMember from human and add it to this family tree
     * @return familyTreeMember created from human
     */
    public FamilyTreeMember add(Human human) {
        FamilyTreeMember member = allMembers.get(human);
        if (member != null) {
            member.addToFamilyTree(this);
        } else {
            member = new FamilyTreeMember(human, this);
            allMembers.put(human, member);
        }
        this.members.add(member);
        return member;
    }

    /**
     * Connect familyMembers to each other
     */
    private void setConnection(FamilyTreeMember memberFrom, FamilyConnection connection, FamilyTreeMember memberTo) {
        // TODO:
        //   1. check members not null
        //   2. check (!member1.equals(member2))
        //   3. add status return?
        memberFrom.connectMember(memberTo, connection);
        if (connection.opposite() != null) memberTo.connectMember(memberFrom, connection.opposite());
    }

    /**
     * Find familyMember from human and set connections between them
     */
    public void setConnection(Human humanFrom, FamilyConnection connection, Human humanTo) {
        // TODO:
        //   1. check members not null
        //   2. check (!member1.equals(member2))
        //   3. add status return?
        FamilyTreeMember member1 = allMembers.get(humanFrom);
        FamilyTreeMember member2 = allMembers.get(humanTo);
        setConnection(member1, connection, member2);
    }

    /**
     * Find or create familyMember from Human and set it as PARENT to first member
     * Child must exist
     */
    public void addParent(Human child, Human parent) {
        FamilyTreeMember familyChild = allMembers.get(child);
        FamilyTreeMember familyParent = allMembers.get(parent);
        if (familyParent == null) {
            add(parent);
            familyParent = allMembers.get(parent);
        }
        setConnection(familyChild, FamilyConnection.CHILD, familyParent);
    }

    /**
     * Find or create familyMember from Human and set it as CHILD to first member
     * Parent must exist
     */
    public void addChild(Human parent, Human child) {
        FamilyTreeMember familyParent = allMembers.get(parent);
        FamilyTreeMember familyChild = allMembers.get(child);
        if (familyChild == null) {
            familyChild = add(child);
        } else {
            familyChild.addToFamilyTree(this);
            this.members.add(familyChild);
        }

        setConnection(familyParent, FamilyConnection.PARENT, familyChild);
    }

    /**
     * Find or create familyMember from Human and set it as WIFE to first member
     * Husband must exist
     */
    public void addWife(Human husband, Human wife) {
        FamilyTreeMember familyHusband = allMembers.get(husband);
        FamilyTreeMember familyWife = allMembers.get(wife);
        if (familyWife == null) {
            familyWife = add(wife);
        } else {
            familyWife.addToFamilyTree(this);
            this.members.add(familyWife);
        }
        setConnection(familyHusband, FamilyConnection.HUSBAND, familyWife);
    }

    /**
     * Find or create familyMembers from list of Humans and set it as CHILD to first list of members
     * Parents must exist
     */
    public void addChildren(List<Human> parents, List<Human> children) {
        for (Human parent : parents) {
            for (Human child : children) {
                addChild(parent, child);
            }
        }
    }

    /**
     * return Set of FamilyMember`s to whom this human is $connection
     */
    public Set<FamilyTreeMember> findRelatedMembers(Human human, FamilyConnection connection) {
        Set<FamilyTreeMember> result = new HashSet<>();
        FamilyTreeMember member = allMembers.get(human);
        if (member != null && members.contains(member)) {
            result = member.getRelatedMembers(connection);
        }
        return result;
    }

    /**
     * return Set of all other familyTrees that are connected to members of current Tree
     */
    public Set<FamilyTree> findConnectedFamilies() {
        Set<FamilyTree> result = new HashSet<>();
        for (FamilyTreeMember member : members) {
            for (FamilyTree tree : member.getFamilyTrees()) {
                if (!tree.equals(this)) result.add(tree);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "familyName='" + familyName + '\'' +
                ", members=" + members +
                '}';
    }
}
