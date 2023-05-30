import java.util.List;

public class Lib {
    public static void printList(List<Person> someList) {
        StringBuilder someString = new StringBuilder();
        for (Person item : someList) {
            someString.append(item);
            someString.append("\n");
        }
        System.out.println(someString);
    }

}