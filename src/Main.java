import java.io.IOException;
import java.io.Serializable;

/**
 * Main
 */
public class Main implements Serializable {

    public static final String PATH = "family.txt";
    public static void main(String[] args) throws ClassNotFoundException, IOException {      
        FamilyTree family = new FamilyTree();
        treeFilling(family);

        System.out.println("ORIGINAL:\n" + family);

        serialize(family);
        FamilyTree restored = restore();

        System.out.println("RESTORED:\n" + restored);
    }

    /** десериализация */
    private static FamilyTree restore() throws ClassNotFoundException, IOException {        
        CapableOfRestore restorer = new FileHandler();
        return (new FamilyTree()).read(PATH, restorer);
    }

    /** сериализация */
    private static void serialize(FamilyTree family) throws ClassNotFoundException, IOException {
        CapableOfPreserving preserver = new FileHandler();
        family.save(PATH, preserver);
    }

    /** заполнения дерева */
    public static void treeFilling(FamilyTree family){
        Human ancestor1 = new Human("John  Johnson", 1900, Gender.Male);
        Human ancestor2 = new Human("Eliza  Johnson", 1910, Gender.Female);
        Human ancestor3 = new Human("Donald  Ferguson", 1915, Gender.Male);
        Human secondGen1 = new Human("Mike  Johnson", 1920, Gender.Male, ancestor1, ancestor2);
        Human secondGen2 = new Human("Betty  Ferguson", 1930, Gender.Female, ancestor3, null);
        Human thirdGen1 = new Human("Bobby  Johnson", 1940, Gender.Male, secondGen1, secondGen2);
        Human thirdGen2 = new Human("Christine  Johnson", 1950, Gender.Female, secondGen1, null);      
        Human thirdGen3 = new Human("Steve  Gomez", 1960, Gender.Male, null, secondGen2); 
        family.addNewMember(ancestor1);
        family.addNewMember(ancestor2);
        family.addNewMember(ancestor3);
        family.addNewMember(secondGen1);
        family.addNewMember(secondGen2);
        family.addNewMember(thirdGen1);
        family.addNewMember(thirdGen2);
        family.addNewMember(thirdGen3); 
    }
}