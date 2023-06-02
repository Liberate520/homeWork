import java.io.Serializable;
import java.time.LocalDate;
import comparers.ComparatorFamilyByBirthDate;
import comparers.ComparatorFamilyByChildrenAmount;
import comparers.ComparatorFamilyByName;
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

    public static void main(String[] args) {
        FamilyTree family = restore();

        System.out.println("ORIGINAL:");
        for (Human human : family) {
            System.out.println(human);
        }

        System.out.println("SORTED BY NAME:");
        family.sort(new ComparatorFamilyByName());
        for (Human human : family) {
            System.out.println(human);
        }

        System.out.println("SORTED BY BIRTHDATE:");
        family.sort(new ComparatorFamilyByBirthDate());
        for (Human human : family) {
            System.out.println(human);
        }

        System.out.println("SORTED BY CHILDREN AMOUNT:");
        family.sort(new ComparatorFamilyByChildrenAmount());
        for (Human human : family) {
            System.out.println(human);
        }

        serialize(family);
    }

    /** десериализация */
    private static FamilyTree restore() {
        CapableOfRestore restorer = new FileHandler();
        return (new FamilyTree()).read(PATH, restorer);
    }

    /** сериализация */
    private static void serialize(FamilyTree family) {
        CapableOfPreserving preserver = new FileHandler();
        family.save(PATH, preserver);
    }

    /** заполнения дерева */
    public static void treeFilling(FamilyTree family) {
        Human ancestor1 = new Human("John Johnson", LocalDate.of(1910, 1, 2), Gender.Male);
        Human ancestor2 = new Human("Eliza Johnson", LocalDate.of(1909, 2, 4), Gender.Female);
        Human ancestor3 = new Human("Donald Ferguson", LocalDate.of(1908, 3, 6), Gender.Male);
        Human secondGen1 = new Human("Mike Johnson", LocalDate.of(1930, 4, 10), Gender.Male, ancestor1, ancestor2);
        Human secondGen2 = new Human("Betty Ferguson", LocalDate.of(1925, 5, 12), Gender.Female, ancestor3, null);
        Human thirdGen1 = new Human("Bobby Johnson", LocalDate.of(1950, 6, 14), Gender.Male, secondGen1, secondGen2);
        Human thirdGen2 = new Human("Christine Johnson", LocalDate.of(1955, 7, 16), Gender.Female, secondGen1, null);
        Human thirdGen3 = new Human("Steve Gomez", LocalDate.of(1951, 8, 18), Gender.Male, null, secondGen2);
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

/** OUTPUT=============================
 * ORIGINAL:
 * Bobby Johnson (14 June 1950)
 * [Male] 0 children,
 * father: Mike Johnson
 * mother: Betty Ferguson
 * 
 * Steve Gomez (18 August 1951)
 * [Male] 0 children,
 * mother: Betty Ferguson
 * 
 * Christine Johnson (16 July 1955)
 * [Female] 0 children,
 * father: Mike Johnson
 * 
 * Donald Ferguson (06 March 1908)
 * [Male] 1 children,
 * 
 * Eliza Johnson (04 February 1909)
 * [Female] 1 children,
 * 
 * John Johnson (02 January 1910)
 * [Male] 1 children,
 * 
 * Betty Ferguson (12 May 1925)
 * [Female] 2 children,
 * father: Donald Ferguson
 * 
 * Mike Johnson (10 April 1930)
 * [Male] 2 children,
 * father: John Johnson
 * mother: Eliza Johnson
 * 
 * SORTED BY NAME:
 * Betty Ferguson (12 May 1925)
 * [Female] 2 children,
 * father: Donald Ferguson
 * 
 * Bobby Johnson (14 June 1950)
 * [Male] 0 children,
 * father: Mike Johnson
 * mother: Betty Ferguson
 * 
 * Christine Johnson (16 July 1955)
 * [Female] 0 children,
 * father: Mike Johnson
 * 
 * Donald Ferguson (06 March 1908)
 * [Male] 1 children,
 * 
 * Eliza Johnson (04 February 1909)
 * [Female] 1 children,
 * 
 * John Johnson (02 January 1910)
 * [Male] 1 children,
 * 
 * Mike Johnson (10 April 1930)
 * [Male] 2 children,
 * father: John Johnson
 * mother: Eliza Johnson
 * 
 * Steve Gomez (18 August 1951)
 * [Male] 0 children,
 * mother: Betty Ferguson
 * 
 * SORTED BY BIRTHDATE:
 * Donald Ferguson (06 March 1908)
 * [Male] 1 children,
 * 
 * Eliza Johnson (04 February 1909)
 * [Female] 1 children,
 * 
 * John Johnson (02 January 1910)
 * [Male] 1 children,
 * 
 * Betty Ferguson (12 May 1925)
 * [Female] 2 children,
 * father: Donald Ferguson
 * 
 * Mike Johnson (10 April 1930)
 * [Male] 2 children,
 * father: John Johnson
 * mother: Eliza Johnson
 * 
 * Bobby Johnson (14 June 1950)
 * [Male] 0 children,
 * father: Mike Johnson
 * mother: Betty Ferguson
 * 
 * Steve Gomez (18 August 1951)
 * [Male] 0 children,
 * mother: Betty Ferguson
 * 
 * Christine Johnson (16 July 1955)
 * [Female] 0 children,
 * father: Mike Johnson
 * 
 * SORTED BY CHILDREN AMOUNT:
 * Bobby Johnson (14 June 1950)
 * [Male] 0 children,
 * father: Mike Johnson
 * mother: Betty Ferguson
 * 
 * Steve Gomez (18 August 1951)
 * [Male] 0 children,
 * mother: Betty Ferguson
 * 
 * Christine Johnson (16 July 1955)
 * [Female] 0 children,
 * father: Mike Johnson
 * 
 * Donald Ferguson (06 March 1908)
 * [Male] 1 children,
 * 
 * Eliza Johnson (04 February 1909)
 * [Female] 1 children,
 * 
 * John Johnson (02 January 1910)
 * [Male] 1 children,
 * 
 * Betty Ferguson (12 May 1925)
 * [Female] 2 children,
 * father: Donald Ferguson
 * 
 * Mike Johnson (10 April 1930)
 * [Male] 2 children,
 * father: John Johnson
 * mother: Eliza Johnson
 */