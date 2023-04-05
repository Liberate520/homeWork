import java.util.Comparator;

public class ComparBySecondName implements Comparator<Person>{

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getSecondName().compareTo(person2.getSecondName());
    }
}
