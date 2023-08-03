import java.io.Serializable;
import java.time.LocalDate;

public class Main{

// Не понимаю почему файл не записывается

    public static void main(String[] args) {

        Family_tree familyTree = new Family_tree();
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/familyTree.out";

        Person male_1 = new Person(Gender.male, "Дуплев", "Анатолий", "Константинович", LocalDate.of(1972, 3, 8), null);
        Person male_2 = new Person(Gender.male, "Дуплев", "Дмитрий", "Анатольевия", LocalDate.of(1994, 6, 6), null);
        Person male_3 = new Person(Gender.male, "Дуплев", "Константин", "Афанасьевич", LocalDate.of(1943, 5, 19),
        LocalDate.of(2008, 8, 7));
        Person female_1 = new Person(Gender.female, "Кох", "Светлана", "Анатольевна", LocalDate.of(1998, 8, 30), null);
        Person male_4 = new Person(Gender.male, "Кох", "Артем", "Викторович", LocalDate.of(2021, 3, 13), null);


        
        Family_tree relat = new Family_tree();

        relat.appendPerentChild(female_1, male_4);
        relat.appendPerentChild(male_1, female_1);
        relat.appendPerentChild(male_1, male_2);
        relat.appendPerentChild(male_3, male_1);

        familyTree.addPerson(male_1);
        familyTree.addPerson(male_2);
        familyTree.addPerson(male_3);
        familyTree.addPerson(male_4);
        familyTree.addPerson(female_1);

        fileHandler.writeFamilyTree((Serializable) familyTree, filePath);
        //System.out.println(fileHandler.readFamilyTree(filePath));
        
        System.out.println(male_1.getInfo());

        System.out.print("Дети Светланы: ");
        System.out.println(new Research(relat).spend(female_1, Relationship.parent));
    }   

}