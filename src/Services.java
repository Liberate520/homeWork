package src;

import java.io.IOException;

public class Services {
    private FamilyTree<Human> familyTree;



    public Services(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public Services() {
    familyTree = new FamilyTree<>();}

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void load(String path) throws IOException, ClassNotFoundException {
        familyTree.load(path);
    }
    public void save(String path) throws IOException {
        familyTree.save(path);
    }

    public void creteHuman(){
        new Stat(familyTree.maxId());
        if(familyTree==null){
            familyTree = new FamilyTree<>();
        }
        Human human = new Human();
        human.createUnit();
        familyTree.addToFamily(human);
    }


}
