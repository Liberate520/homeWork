import java.util.Comparator;

public class ComparByChild implements Comparator<Person>{

    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getChildrens().size() == person2.getChildrens().size()) {
            return 0;
        } else if (person1.getChildrens().size() > person2.getChildrens().size()) {
            return 1;
        }
        else{
            return -1;}
    }
}
