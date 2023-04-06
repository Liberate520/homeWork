import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human humanOne = new Human("Иван", "Иванов", LocalDate.of(1994, 11, 21));
        Human humanTwo = new Human("Анастасия", "Иванова", LocalDate.of(1995, 6, 15));
        Human humanThree = new Human("Алия", "Иванова", LocalDate.of(2018, 3, 8), humanTwo.getId(), humanOne.getId());

        FamilyTree test = new FamilyTree();
        test.add(humanOne);
        test.add(humanTwo);
        test.add(humanThree);
//        System.out.println(test);
//        test.parentsHuman(humanTwo);
//        test.childrensHuman(humanTwo);

        FamilyTree testTwo;
        SaveAndRead data = new SaveAndRead();

        String nameFile = "FamilyTree.bin";
        data.saveFile(test, nameFile);
        testTwo = data.loadFile(nameFile);
        System.out.println(testTwo);
    }
}
