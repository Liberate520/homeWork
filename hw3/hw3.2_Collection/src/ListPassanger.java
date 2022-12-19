import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPassanger implements Iterable<Passanger>{
    private List<Passanger> listPassanger;
    private static int id;

    public ListPassanger() {
        id = 0;
        listPassanger = new ArrayList<>();
    }

    public void addPassanger(String name, String lastname, int numberPassport) {
        Passanger passanger = new Passanger(id++, name, lastname, numberPassport);
        listPassanger.add(passanger);
    }

    @Override
    public Iterator<Passanger> iterator() {
        return listPassanger.iterator();
    }
}
