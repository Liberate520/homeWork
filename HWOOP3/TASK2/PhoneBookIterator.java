package TASK2;
import java.util.Iterator;
import java.util.List;

public class PhoneBookIterator implements Iterator<Contact>{
    private List<Contact> contactsList;
    private int index = 0;

    public PhoneBookIterator(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public boolean hasNext() {
        
        return index < contactsList.size();
    }

    @Override
    public Contact next() {
        
        return contactsList.get(index++);
    }
    

}
