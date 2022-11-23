import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree1 = new FamilyTree();
        Output output = new Output();

        Human human1 = new Human("Cidorov",1, TypeOfGender.Male,
                null,null);
        familyTree1.addHuman(human1);


        Human human2 = new Human("Ivanov",2, TypeOfGender.Male,
                human1,null);
        familyTree1.addHuman(human2);

        Human human3 = new Human("Petrova",3, TypeOfGender.Female,
                human1,null);
        familyTree1.addHuman(human3);


        output.ShowСhildren(human1, familyTree1.getMainTree());


    }
}
