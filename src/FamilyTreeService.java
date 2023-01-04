public class FamilyTreeService implements Service {

    private FamilyTree familyTree;

    public FamilyTreeService(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public Mammal getMember(String name) {
        return familyTree.getMemberByName(name);
    }

    @Override
    public FamilyTree getTree() {
        return familyTree;
    }
}