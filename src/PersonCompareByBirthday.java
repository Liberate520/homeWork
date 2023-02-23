import java.util.Comparator;

public class PersonCompareByBirthday implements Comparator<Person> {

    @Override
    public int compare(Person per1, Person per2) {
//        System.out.printf("%s = %d\t%s = %d\n",per1.getName(),per1.getBirthDay(),per2.getName(),per2.getBirthDay());
        return per1.getBirthDay().compareTo(per2.getBirthDay());
    }
}
