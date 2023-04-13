package familyTreeApi;

import familyTreeApi.dog.Dog;
import familyTreeApi.familyTree.FamilyTree;
import familyTreeApi.familyTree.comparators.MemberComparatorByBornDate;
import familyTreeApi.familyTree.comparators.MemberComparatorByFirstName;
import familyTreeApi.familyTree.comparators.MemberComparatorByGender;
import familyTreeApi.familyTree.comparators.MemberComparatorByLastName;
import familyTreeApi.handler.FileHandler;
import familyTreeApi.member.Member;
import familyTreeApi.person.Person;
import familyTreeApi.trees.TOTrees;
import familyTreeApi.trees.TreeOfTrees;

import java.util.Calendar;
import java.util.List;

public class Service {
    private FamilyTree<? extends Member> currentEditingFTree;
    private String typeMember;
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

    public void editFTree() {

    }

    public boolean addFamilyTree(String member, String newName) {
        typeMember = member;
        if (typeMember.equals("person")) {
            currentEditingFTree = new FamilyTree<Person>(newName, typeMember);
        } else if (typeMember.equals("dog")) {
            currentEditingFTree = new FamilyTree<Dog>(newName, typeMember);
        } else {
            return false;
        }
        return this.getTreeOfTrees().addFamilyTree(currentEditingFTree);
    }

    public void addMember(String familyTreeName, Member member) {
        addMember(this.findFamilyTree(familyTreeName), member);
    }

    public boolean addMember(String name, String kind, boolean isMale, Calendar bornDate) {
        if (typeMember.equals("person")) {
            addPerson(name, kind, isMale, bornDate);
        } else if (typeMember.equals("dog")) {
            currentEditingFTree.addMember(member);
        } else {
            return false;
        }
        return true;
    }

    private Member addPerson(String name, String kind, boolean isMale, Calendar bornDate) {
        Member member = new Person(name, kind, isMale, bornDate);
        currentEditingFTree.addMember(member);
        return member;
    }

    public void addMember(String firstName, String firstNameSample) {
        for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
            addMember(familyTree, firstName, firstNameSample);
        }
    }

    public boolean addMember(String familyTreeName, String name, String firstNameSample) {
        addMember(this.findFamilyTree(familyTreeName), firstName, firstNameSample);
    }

    private void addMember(FamilyTree<Member> familyTree, String name, String nameSample) {
        Member member = new Member(name, familyTree.findMember(nameSample));
        member.setName(name);
        familyTree.addMember(member);
    }

    public boolean addChild(String nameParent, String nameChild) {
        return currentEditingFTree.findMember(nameParent).addChild(currentEditingFTree.findMember(nameChild));
    }

    public boolean addMarried(String nameMarried1, String nameMarried2, boolean isMarried) {
        return currentEditingFTree.findMember(nameMarried1).addMarried(currentEditingFTree.findMember(nameMarried2), isMarried);
    }

    private FamilyTree<Member> findFamilyTree(String name) {
        return this.getTreeOfTrees().findFamilyTree(name);
    }

    public boolean isFindFamilyTree(String name) {
        currentEditingFTree = this.getTreeOfTrees().findFamilyTree(name);
        typeMember = currentEditingFTree.getTypeMember();
        return currentEditingFTree != null;
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
        List<Member> members = familyTree.getMembers();
        members.sort(new MemberComparatorByFirstName<>());
        for (familyTreeApi.member.Member member : members) {
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
        List<Member> members = familyTree.getMembers();
        members.sort(new MemberComparatorByLastName<>());
        for (familyTreeApi.member.Member member : members) {
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
        List<Member> members = familyTree.getMembers();
        members.sort(new MemberComparatorByGender<>());
        for (familyTreeApi.member.Member member : members) {
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
        for (familyTreeApi.member.Member member : members) {
            ((List<Member>) ((ThreadLocal<Object>) member.getChildren())).sort(new MemberComparatorByBornDate<>());
            ((List<Member>) ((ThreadLocal<Object>) member.getParents())).sort(new MemberComparatorByBornDate<>());
        }
    }

    public String printInfo() {
        return this.getTreeOfTrees().printAllInfo();
    }

    public String printTrees() {
        return this.getTreeOfTrees().printTrees();
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