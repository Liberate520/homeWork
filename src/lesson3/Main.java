import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree;
        ReadWritable fileHandler = new FileHandler("familydata");
        tree = (FamilyTree) fileHandler.read();
        tree.add(new Human("Vasily", Gender.MALE));
        tree.add(new Human("Mary", Gender.FEMALE));
        tree.add(new Human("Christine", Gender.FEMALE,tree.getByName("Vasily"), tree.getByName("Mary")));
        tree.add(new Human("Semen", Gender.MALE, tree.getByName("Vasily"), tree.getByName("Mary")));
        fileHandler.write(tree);
        //System.out.println(tree. getInfo());
        for(Human human : tree){
            System.out.println(human.getInfo());
        }
        System.out.println(tree.sortByName().getInfo());
    }
}
