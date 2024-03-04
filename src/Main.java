
import java.io.Serializable;
import java.time.LocalDate;



public class Main {
    public static void main(String[] args) {

        FamilyTree tree = mainTree();
        System.out.println(tree);

        save(tree);

    }

    private static FamilyTree load(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/tree.txt";
        return (FamilyTree) fileHandler.read(filePath);
    }

    private static void save(FamilyTree tree){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/tree.txt";
        fileHandler.save(tree,filePath);
    }


    static FamilyTree mainTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male,  null, null, LocalDate.of(1980,6,24), null);

        Human masha = new Human("Маша", Gender.Female, null, null, LocalDate.of(1985, 6, 15), null);


        tree.add(vasya);
        tree.add(masha);

//
        tree.setWedding(vasya, masha);
//
        Human lena = new Human("Лена", Gender.Female, vasya, masha, LocalDate.of(2010,7,23), null);

        Human ivan = new Human("Иван", Gender.Male,vasya, masha, LocalDate.of(2005, 7, 1), null);

        tree.add (lena);
        tree.add (ivan);

        Human Inna = new Human("Инна", Gender.Female,null, null, LocalDate.of(1954,11,25), null);
        Inna.addChild(vasya);
        tree.add(Inna);
//

        return tree;
    }


}
