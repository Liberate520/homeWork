import java.util.ArrayList;

public class Tree {
    static ArrayList<Printable> myTree = new ArrayList<Printable>();
    static ArrayList<Printable> dogTree = new ArrayList<Printable>();
    static ArrayList<Printable> children = new ArrayList<Printable>();
    Printable union;

    public void createTreeHuman(String name, Human mom, Human dad) {
        Printable union = (Printable) new Human(name, mom, dad);
        myTree.add(union);
    }


    public void createTreeDog(String name, int breed, Dog mom, Dog dad) {
        Printable union = (Printable) new Dog(name,breed,mom,dad);
        myTree.add(union);
    }

    public ArrayList<Printable> addChildren(Human mom, Human dad){
        for(int i = 0; i< myTree.size(); i++){
            if(myTree.get(i).getMom() == mom && (myTree.get(i)).getDad() == dad){
                children.add(myTree.get(i));
            }


        }


        return children;
    }
}
