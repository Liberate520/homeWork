import dog.Dog;
import familyTree.FamilyTree;
import familyTree.comparators.MemberComparatorByBornDate;
import familyTree.comparators.MemberComparatorByFirstName;
import familyTree.comparators.MemberComparatorByGender;
import familyTree.comparators.MemberComparatorByLastName;
import handler.FileHandler;
import member.Member;
import person.Person;
import trees.TOTrees;
import trees.TreeOfTrees;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Service {
    private TOTrees<FamilyTree> treeOfTrees;

    public Service() {
        this(new TreeOfTrees<>());
    }

    public Service(TOTrees treeOfTrees) {
        this.treeOfTrees = treeOfTrees;
    }

    public TOTrees<FamilyTree> getTreeOfTrees() {
        return this.treeOfTrees;
    }

    public void addFamilyTree(String member, String newName) {
        if (member.equals("Person")) {
            this.getTreeOfTrees().addFamilyTree(new FamilyTree<Person>(newName));
        } else if (member.equals("Dog")) {
            this.getTreeOfTrees().addFamilyTree(new FamilyTree<Dog>(newName));
        } else {
            System.out.println("Указан отличный от Собак и Людей");
        }
    }

//    public void addFamilyTree(Member member) {
//        this.getTreeOfTrees().addFamilyTree(new FamilyTree<>(member));
//    }
//
//    public void addFamilyTree(FamilyTree<Member> familyTree) {
//        this.getTreeOfTrees().addFamilyTree(familyTree);
//    }
//
//    public void addMember(Member member) {
//        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
//            addMember(familyTree, member);
//        }
//    }

    public void addMember(String familyTreeName, Member member) {
        addMember(this.findFamilyTree(familyTreeName), member);
    }

    private void addMember(FamilyTree<Member> familyTree, Member member) {
        familyTree.addMember(member);
    }

    public void addMember(String firstName, String lastName, boolean isMan, Calendar bornDate) {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            addMember(familyTree, firstName, lastName, isMan, bornDate);
        }
    }

    public void addMember(String familyTreeName, String firstName, String lastName, boolean isMan) {
        addMember(familyTreeName, firstName, lastName, isMan, new GregorianCalendar());
    }

    public void addMember(String familyTreeName, String firstName, String lastName, boolean isMan, Calendar bornDate) {
        addMember(this.findFamilyTree(familyTreeName), firstName, lastName, isMan, bornDate);
    }

    private Member addMember(FamilyTree<Member> familyTree, String firstName, String lastName, boolean isMan, Calendar bornDate) {
        Member member = new Member(firstName, lastName, isMan, bornDate);
        familyTree.addMember(member);
        return member;
    }

    public void addMember(String firstName, String firstNameSample) {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            addMember(familyTree, firstName, firstNameSample);
        }
    }

    public void addMember(String familyTreeName, String firstName, String firstNameSample) {
        addMember(this.findFamilyTree(familyTreeName), firstName, firstNameSample);
    }

    private void addMember(FamilyTree<Member> familyTree, String firstName, String firstNameSample) {
        Member member = new Member(firstName, familyTree.findMember(firstNameSample));
        member.setName(firstName);
        familyTree.addMember(member);
    }

    public void addChild(String firstNameParent, String firstNameChild, String lastNameChild, boolean isMan) {
        addChild(firstNameParent, firstNameChild, lastNameChild, isMan, new GregorianCalendar());
    }

    public void addChild(String firstNameParent, String firstNameChild, String lastNameChild, boolean isMan, Calendar bornDate) {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            addChild(familyTree, firstNameParent, firstNameChild, lastNameChild, isMan, bornDate);
        }
    }

    private void addChild(FamilyTree<Member> familyTree, String firstNameParent, String firstNameChild, String lastNameChild, boolean isMan, Calendar bornDate) {
        familyTree.findMember(firstNameParent).addChild(this.addMember(familyTree, firstNameChild, lastNameChild, isMan, bornDate));
    }

    public void addChild(String firstNameParent, String firstNameChild) {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            addChild(familyTree, firstNameParent, firstNameChild);
        }
    }

    public void addChild(String familyTreeName, String firstNameParent, String firstNameChild) {
        addChild(this.findFamilyTree(familyTreeName), firstNameParent, firstNameChild);
    }

    private void addChild(FamilyTree<Member> familyTree, String firstNameParent, String firstNameChild) {
        familyTree.findMember(firstNameParent).addChild(familyTree.findMember(firstNameChild));
    }

    public void addMarried(String firstNameMarried1, String firstNameMarried2, boolean isMarried) {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            addMarried(familyTree, firstNameMarried1, firstNameMarried2, isMarried);
        }
    }

    public void addMarried(String familyTreeName, String firstNameMarried1, String firstNameMarried2, boolean isMarried) {
        addMarried(this.findFamilyTree(familyTreeName), firstNameMarried1, firstNameMarried2, isMarried);
    }

    private void addMarried(FamilyTree<Member> familyTree, String firstNameMarried1, String firstNameMarried2, boolean isMarried) {
        familyTree.findMember(firstNameMarried1).addMarried(familyTree.findMember(firstNameMarried2), isMarried);
    }

    public FamilyTree<Member> findFamilyTree(String name) {
        return this.getTreeOfTrees().findFamilyTree(name);
    }

    public Member findMember(String firstName) {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            return familyTree.findMember(firstName);
        }
        return null;
    }

    public void sortByFirstName() {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            this.sortByFirstName(familyTree);
        }
    }

    public void sortByFirstName(String familyTreeName) {
        this.sortByFirstName(this.findFamilyTree(familyTreeName));
    }

    private void sortByFirstName(FamilyTree<Member> familyTree) {
        List<Member> members = familyTree.getMembersList();
        members.sort(new MemberComparatorByFirstName<>());
        for (member.Member member : members) {
            ((List<Member>) ((ThreadLocal<Object>) member.getChildren())).sort(new MemberComparatorByFirstName<>());
            ((List<Member>) ((ThreadLocal<Object>) member.getParents())).sort(new MemberComparatorByFirstName<>());
        }
    }

    public void sortByLastName() {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            this.sortByLastName(familyTree);
        }
    }

    public void sortByLastName(String familyTreeName) {
        this.sortByLastName(this.findFamilyTree(familyTreeName));
    }

    private void sortByLastName(FamilyTree<Member> familyTree) {
        List<Member> members = familyTree.getMembersList();
        members.sort(new MemberComparatorByLastName<>());
        for (member.Member member : members) {
            ((List<Member>) ((ThreadLocal<Object>) member.getChildren())).sort(new MemberComparatorByLastName<>());
            ((List<Member>) ((ThreadLocal<Object>) member.getParents())).sort(new MemberComparatorByLastName<>());
        }
    }

    public void sortByGender() {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            this.sortByGender(familyTree);
        }
    }

    public void sortByGender(String familyTreeName) {
        this.sortByGender(this.findFamilyTree(familyTreeName));
    }

    private void sortByGender(FamilyTree<Member> familyTree) {
        List<Member> members = familyTree.getMembersList();
        members.sort(new MemberComparatorByGender<>());
        for (member.Member member : members) {
            ((List<Member>) ((ThreadLocal<Object>) member.getChildren())).sort(new MemberComparatorByGender<>());
            ((List<Member>) ((ThreadLocal<Object>) member.getParents())).sort(new MemberComparatorByGender<>());
        }
    }

    public void sortByBornDate() {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            this.sortByBornDate(familyTree);
        }
    }

    public void sortByBornDate(String familyTreeName) {
        this.sortByBornDate(this.findFamilyTree(familyTreeName));
    }

    private void sortByBornDate(FamilyTree<Member> familyTree) {
        List<Member> members = familyTree.getMembers();
        members.sort(new MemberComparatorByBornDate<>());
        for (member.Member member : members) {
            ((List<Member>) ((ThreadLocal<Object>) member.getChildren())).sort(new MemberComparatorByBornDate<>());
            ((List<Member>) ((ThreadLocal<Object>) member.getParents())).sort(new MemberComparatorByBornDate<>());
        }
    }

    public void printInfo() {
        System.out.println(this.getTreeOfTrees().printAllInfo());
    }

    public void printTrees() {
        this.getTreeOfTrees().printTrees();
    }

    public void save(String fileName) {
        FileHandler<TreeOfTrees<FamilyTree>> fileHandler = new FileHandler<>();
        this.getTreeOfTrees().save(fileHandler, fileName);
    }

    public TreeOfTrees<FamilyTree> read(String fileName) {
        FileHandler<TreeOfTrees> fileHandler = new FileHandler<>();
        return fileHandler.read(fileName);
    }
}