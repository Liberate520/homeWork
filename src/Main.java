import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human humanKrivenkoP = new Human("Кривенко","Павел");
        Human humanKrivenkoS = new Human("Кривенко","Светлана");
        Human humanKrivenkoAy = new Human("Кривенко","Андрей",humanKrivenkoS,humanKrivenkoP);
        Human humanKrivenkoAt = new Human("Кривенко","Антон",humanKrivenkoS,humanKrivenkoP);
        Human humanKrivenkoO = new Human("Кривенко","Ольга");
        FamilyTree familyKrivenko = new FamilyTree();
        FamilyTree familyKrivenko2 = new FamilyTree();


        familyKrivenko.addFamilyTree(humanKrivenkoP);
        familyKrivenko.addFamilyTree(humanKrivenkoS);
        familyKrivenko.addFamilyTree(humanKrivenkoAy);
        familyKrivenko.addFamilyTree(humanKrivenkoAt);

        familyKrivenko2.addFamilyTree(humanKrivenkoAy);
        familyKrivenko2.addFamilyTree(humanKrivenkoO);

        String fileAddress = "fileTree.out";
        saveToFile(familyKrivenko,fileAddress);

        FamilyTree familyKrivenkoFile = new FamilyTree();
        readFile(familyKrivenkoFile,fileAddress);


        List<Human> children = humanKrivenkoAy.getMother().getChildren();
        children.remove(humanKrivenkoAy);
        System.out.println(children);



    }
    public static void saveToFile(FileProcessing file, String address) throws IOException{
        file.save(address);
    }

    public static void readFile(FileProcessing file, String address) throws IOException, ClassNotFoundException{
        file.read(address);
    }


}
