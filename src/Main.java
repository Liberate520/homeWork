import java.io.Serializable;
import java.time.LocalDate;

import filework.CapableOfPreserving;
import filework.CapableOfRestore;
import filework.FileHandler;
import tree.FamilyTree;
import tree.Gender;
import tree.Human;

/**
 * Main
 */
public class Main implements Serializable {

    public static final String PATH = "family.txt";
    public static void main(String[] args){      
        FamilyTree family = restore();
        
        for (Human human : family) {
            System.out.println(human);
        }
        serialize(family);        
    }

    /** десериализация */
    private static FamilyTree restore(){        
        CapableOfRestore restorer = new FileHandler();
        return (new FamilyTree()).read(PATH, restorer);
    }

    /** сериализация */
    private static void serialize(FamilyTree family){
        CapableOfPreserving preserver = new FileHandler();
        family.save(PATH, preserver);
    }

    /** заполнения дерева */
    public static void treeFilling(FamilyTree family){
        Human ancestor1 =  new Human("John  Johnson",        LocalDate.of(1900, 1, 2),  Gender.Male);
        Human ancestor2 =  new Human("Eliza  Johnson",       LocalDate.of(1910, 2, 4),  Gender.Female);
        Human ancestor3 =  new Human("Donald  Ferguson",     LocalDate.of(1920, 3, 6),  Gender.Male);
        Human secondGen1 = new Human("Mike  Johnson",        LocalDate.of(1930, 4, 10), Gender.Male, ancestor1, ancestor2);
        Human secondGen2 = new Human("Betty  Ferguson",      LocalDate.of(1940, 5, 12), Gender.Female, ancestor3, null);
        Human thirdGen1 =  new Human("Bobby  Johnson",       LocalDate.of(1950, 6, 14), Gender.Male, secondGen1, secondGen2);
        Human thirdGen2 =  new Human("Christine  Johnson",   LocalDate.of(1960, 7, 16), Gender.Female, secondGen1, null);      
        Human thirdGen3 =  new Human("Steve  Gomez",         LocalDate.of(1970, 8, 18), Gender.Male, null, secondGen2); 
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