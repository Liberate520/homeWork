package tree;
import person.Person;

public class PersExistEx extends Exception{
    public PersExistEx(Person person, String message) {
        super(person.getName()+" "+person.getLastname()+" "+message);
    }
}
