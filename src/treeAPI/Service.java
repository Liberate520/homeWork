package treeAPI;

import treeAPI.familyTree.FamilyTree;
import treeAPI.familyTree.comparators.SampleComparatorByBirthDay;
import treeAPI.familyTree.comparators.SampleComparatorByFirstName;
import treeAPI.familyTree.comparators.SampleComparatorByGender;
import treeAPI.familyTrees.InterfaceTrees;
import treeAPI.familyTrees.TreesHolder;
import treeAPI.handler.FileHandler;
import treeAPI.human.Human;
import treeAPI.sample.Sample;

import java.util.Calendar;
import java.util.List;

public class Service {
    private FamilyTree<? extends Sample> tree;
    private InterfaceTrees<FamilyTree> treesHolder;

    public Service() {
        this(new TreesHolder<>());
    }
    public Service(InterfaceTrees treesHolder) {
        this.treesHolder = treesHolder;
    }
    public InterfaceTrees<FamilyTree> getTreesHolder() {
        return this.treesHolder;
    }

    public boolean addFamilyTree(String newName) {
        tree = new FamilyTree<Human>(newName);
        return this.getTreesHolder().addFamilyTree(tree);
    }

    public boolean addSample(String name, boolean isMale, Calendar bornDate) {
        return addHuman(name, isMale, bornDate);
    }

    private boolean addHuman(String name, boolean isMale, Calendar bornDate) {
        Sample human = new Human(name, isMale, bornDate);
        return tree.addSample(human);
    }

    public boolean addChild(String nameParent, String nameChild) {
        return tree.findSample(nameParent).addChildren(tree.findSample(nameChild));
    }

    public boolean addMarried(String nameMarried1, String nameMarried2, boolean isMarried) {
        return tree.findSample(nameMarried1).addMarried(tree.findSample(nameMarried2), isMarried);
    }

    private FamilyTree<Sample> findFamilyTree(String name) {
        return this.getTreesHolder().findFamilyTree(name);
    }

    public boolean isFindFamilyTree(String name) {
        tree = this.getTreesHolder().findFamilyTree(name);
        return tree != null;
    }

    public Sample findMember(String name) {
        return tree.findSample(name);
    }

    public boolean isFindMember(String name) {
        return tree.findSample(name) != null;
    }

    public void sortByFirstName() {
        for (FamilyTree<Sample> familyTree : this.getTreesHolder()) {
            this.sortByFirstName(familyTree);
        }
    }

    public void sortByFirstName(String familyTreeName) {
        this.sortByFirstName(this.findFamilyTree(familyTreeName));
    }

    private void sortByFirstName(FamilyTree<Sample> familyTree) {
        List<Sample> samples = familyTree.getSamples();
        samples.sort(new SampleComparatorByFirstName<>());
        for (Sample member : samples) {
            member.getChildren().sort(new SampleComparatorByFirstName<>());
            member.getParents().sort(new SampleComparatorByFirstName<>());
        }
    }

    public void sortByGender() {
        for (FamilyTree<Sample> familyTree : this.getTreesHolder()) {
            this.sortByGender(familyTree);
        }
    }

    public void sortByGender(String familyTreeName) {
        this.sortByGender(this.findFamilyTree(familyTreeName));
    }

    private void sortByGender(FamilyTree<Sample> familyTree) {
        List<Sample> members = familyTree.getSamples();
        members.sort(new SampleComparatorByGender<>());
        for (Sample member : members) {
            member.getChildren().sort(new SampleComparatorByGender<>());
            member.getParents().sort(new SampleComparatorByGender<>());
        }
    }

    public void sortByBornDate() {
        for (FamilyTree<Sample> familyTree : this.getTreesHolder()) {
            this.sortByBornDate(familyTree);
        }
    }

    public void sortByBornDate(String familyTreeName) {
        this.sortByBornDate(this.findFamilyTree(familyTreeName));
    }

    private void sortByBornDate(FamilyTree<Sample> familyTree) {
        List<Sample> members = familyTree.getSamples();
        members.sort(new SampleComparatorByBirthDay<>());
        for (Sample member : members) {
            member.getChildren().sort(new SampleComparatorByBirthDay<>());
            member.getParents().sort(new SampleComparatorByBirthDay<>());
        }
    }

    public String printInfo() {
        return this.getTreesHolder().printAllInfo();
    }

    public String printTrees() {
        return this.getTreesHolder().printTrees();
    }

    public String printTree() {
        return tree.printTree();
    }

    public String printMemberInfo(String name) {
        if (isFindMember(name)){
            return this.findMember(name).printInfo();
        }else{
            return "Человека с таким именем не найдено";
        }
    }

    public void save(String fileName) {
        FileHandler<TreesHolder<FamilyTree>> fileHandler = new FileHandler<>();
        this.getTreesHolder().save(fileHandler, fileName);
    }

    public TreesHolder<FamilyTree> read(String fileName) {
        FileHandler<TreesHolder> fileHandler = new FileHandler<>();
        return fileHandler.read(fileName);
    }
}