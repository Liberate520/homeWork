package homeWork.tree2.tests;

import homeWork.tree2.familyTree.FamilyTree;
import homeWork.tree2.familyTree.comparator.HumanComparatorByName;
import homeWork.tree2.tests.TestClass;

public class TestServiceClass {
    private FamilyTree testGroup;
    public TestServiceClass(FamilyTree testGroup) {this.testGroup = testGroup;}

    public void fillTestGroup(FamilyTree testGroup) {
        TestClass element = new TestClass();
        testGroup.addPeople(element);
    }

    public void sortByParams(){
        testGroup.familyMembersList().sort(new TestComparator().reversed());
    }


}
