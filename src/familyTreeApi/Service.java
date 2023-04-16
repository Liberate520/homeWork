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

    public boolean addMember(String name, String kind, boolean isMale, Calendar bornDate) {
        if (typeMember.equals("person")) {
            return addPerson(name, kind, isMale, bornDate);
        } else if (typeMember.equals("dog")) {
            return addDog(name, kind, isMale, bornDate);
        } else {
            return false;
        }
    }

    private boolean addPerson(String name, String kind, boolean isMale, Calendar bornDate) {
        Member person = new Person(name, kind, isMale, bornDate);
        return currentEditingFTree.addMember(person);
    }

    private boolean addDog(String name, String kind, boolean isMale, Calendar bornDate) {
        Member dog = new Dog(name, kind, isMale, bornDate);
        return currentEditingFTree.addMember(dog);
    }

    public boolean addMember(String newName, String nameSample) {
        if (typeMember.equals("person")) {
            return addPersonByPerson(newName, (Person) this.findMember(nameSample));
        } else if (typeMember.equals("dog")) {
            return addDogByDog(newName, (Dog) this.findMember(nameSample));
        } else {
            return false;
        }
    }

    private boolean addPersonByPerson(String name, Person person) {
        Member newPerson = new Person(name, person);
        return currentEditingFTree.addMember(newPerson);
    }

    private boolean addDogByDog(String name, Dog dog) {
        Member newDog = new Dog(name, dog);
        return currentEditingFTree.addMember(newDog);
    }

    public boolean addChild(String nameParent, String nameChild) {
        return this.findMember(nameParent).addChild(this.findMember(nameChild));
    }

    public boolean addMarried(String nameMarried1, String nameMarried2, boolean isMarried) {
        return this.findMember(nameMarried1).addMarried(this.findMember(nameMarried2), isMarried);
    }

    private FamilyTree<Member> findFamilyTree(String name) {
        return this.getTreeOfTrees().findFamilyTree(name);
    }

    public boolean isFindFamilyTree(String name) {
        currentEditingFTree = findFamilyTree(name);
        if (currentEditingFTree != null) {
            typeMember = currentEditingFTree.getTypeMember();
            return true;
        } else {
            return false;
        }
    }

    public Member findMember(String name) {
        return currentEditingFTree.findMember(name);
    }

    public boolean isFindMember(String name) {
        return this.findMember(name) != null;
    }

    public boolean sortByFirstName() {
        if (currentEditingFTree == null) {
            for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
                this.sortByFirstName(familyTree);
            }
        } else {
            this.sortByFirstName((FamilyTree<Member>) currentEditingFTree);
        }
        return true;
    }

    private void sortByFirstName(FamilyTree<Member> familyTree) {
        List<Member> members = familyTree.getMembers();
        members.sort(new MemberComparatorByFirstName<>());
        for (Member member : members) {
            member.getChildren().sort(new MemberComparatorByFirstName<>());
            member.getParents().sort(new MemberComparatorByFirstName<>());
        }
    }

    public boolean sortByLastName() {
        if (currentEditingFTree == null) {
            for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
                this.sortByLastName(familyTree);
            }
        } else {
            this.sortByLastName((FamilyTree<Member>) currentEditingFTree);
        }
        return true;
    }

    private void sortByLastName(FamilyTree<Member> familyTree) {
        List<Member> members = familyTree.getMembers();
        members.sort(new MemberComparatorByLastName<>());
        for (familyTreeApi.member.Member member : members) {
            member.getChildren().sort(new MemberComparatorByLastName<>());
            member.getParents().sort(new MemberComparatorByLastName<>());
        }
    }

    public boolean sortByGender() {
        if (currentEditingFTree == null) {
            for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
                this.sortByGender(familyTree);
            }
        } else {
            this.sortByGender((FamilyTree<Member>) currentEditingFTree);
        }
        return true;
    }

    private void sortByGender(FamilyTree<Member> familyTree) {
        List<Member> members = familyTree.getMembers();
        members.sort(new MemberComparatorByGender<>());
        for (familyTreeApi.member.Member member : members) {
            member.getChildren().sort(new MemberComparatorByGender<>());
            member.getParents().sort(new MemberComparatorByGender<>());
        }
    }

    public boolean sortByBornDate() {
        if (currentEditingFTree == null) {
            for (FamilyTree<Member> familyTree : this.getTreeOfTrees()) {
                this.sortByBornDate(familyTree);
            }
        } else {
            this.sortByBornDate((FamilyTree<Member>) currentEditingFTree);
        }
        return true;
    }

    private void sortByBornDate(FamilyTree<Member> familyTree) {
        List<Member> members = familyTree.getMembers();
        members.sort(new MemberComparatorByBornDate<>());
        for (familyTreeApi.member.Member member : members) {
            member.getChildren().sort(new MemberComparatorByBornDate<>());
            member.getParents().sort(new MemberComparatorByBornDate<>());
        }
    }

    public String printInfo() {
        return this.getTreeOfTrees().printAllInfo();
    }

    public String printTrees() {
        return this.getTreeOfTrees().printTrees();
    }

    public String printTree() {
        return currentEditingFTree.printTree();
    }

    public String printMemberInfo(String name) {
        if (isFindMember(name)) {
            return this.findMember(name).printInfo();
        } else {
            return "С таким именем член семьи не найден";
        }
    }

    public void save(String fileName) {
        FileHandler<TreeOfTrees<FamilyTree>> fileHandler = new FileHandler<>();
        this.getTreeOfTrees().save(fileHandler, fileName);
    }

    public TreeOfTrees<FamilyTree> read(String fileName) {
        FileHandler<TreeOfTrees> fileHandler = new FileHandler<>();
        return fileHandler.read(fileName);
    }

    public boolean quit() {
        currentEditingFTree = null;
        return false;
    }
}