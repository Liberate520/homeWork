import java.io.IOException;

public class MainHW {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataSave data = new DataSave();
        FamilyTree familyTree1 = new FamilyTree();

        familyTree1.add(new Human("Анна")); 
        familyTree1.add(new Human("Петр")); 
        familyTree1.add(new Human("Миша", familyTree1.getByName("Петр"), familyTree1.getByName("Анна"))); 
        familyTree1.add(new Human("Оля", familyTree1.getByName("Петр"), familyTree1.getByName("Анна")));

        System.out.println(familyTree1);
        data.save(familyTree1,"fileTree.txt");
        data.read("fileTree.txt");
        }
}