package familytree;

import java.util.Date;
import java.util.ArrayList;

public interface IMemeberFactory<T extends FamilyTreeMemeber> {
    T getTreeMemeber(int id, String name, String sex, Date birthDay, ArrayList<T> parents);
}
