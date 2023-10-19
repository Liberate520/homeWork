package family_tree;
import Tree.FamilyTree;
import java.io.IOException;
import java.time.LocalDate;
import Human.Gender;
import Human.Human;
import FileManager.Serialization;



public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FamilyTree Starki = new FamilyTree();
        Human Eddard = new Human("Eddard Stark", LocalDate.of(1244,10,4),null, Gender.Female);
        Human Catelyn = new Human("Catelyn Stark", LocalDate.of(1244, 11, 19), null,Gender.Male);
        //Human Robb = new Human("Robb Stark", LocalDate.of(1254, 5, 12), Male);
        //Human Aria = new Human("Aria Stark", LocalDate.of(1263, 4, 3), Female);
        //Human Jon = new Human("Jon Snow", LocalDate.of(1245, 9, 14), Male);
        //Human Sansa = new Human("Sansa Stark", LocalDate.of(1246, 12, 24), Female);
        //Human Eddard2 = new Human("Eddard Stark", LocalDate.of(1234, 12, 5), Male);
        Starki.addHuman(Eddard);
        Starki.addHuman(Catelyn);
        Catelyn.setSpouse(Eddard);
        System.out.printf(Eddard.getSpouse());


        System.out.printf(Starki.getInfoHuman());


        String filename = "Backup.cfg";
        Serialization fileManager = new Serialization();
        fileManager.saveToFile(filename, Starki);

        Starki = fileManager.loadFromFile(filename);
        System.out.printf(Starki.getInfoHuman());

    }
}