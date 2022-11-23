import java.util.ArrayList;
import java.util.List;

public class Output {
    public void ShowСhildren(Human arg, List<Human> array){
        int searchId = arg.getId();
        int count = 0;
        System.out.println("We are looking for children from the subject =>" + arg.getName());
        for (int i = 0; i < array.size(); i++) {
            Human person = array.get(i);
            if (person.getFather() != null) {
                if (person.getFather().getId() == searchId) {
                    count++;
                    System.out.println(String.
                            format("Child № %d - Surname: %s, Degree of kinship: %s ",
                                    count,person.getName(),
                                    (person.getTypeOfGender() == TypeOfGender.Male) ?
                                            TypeOfRelationship.Son : TypeOfRelationship.Daughter));
                }
            }
        }
        if (count == 0) System.out.println("There are no children");

    }

}
