package familytree.Tree;

import java.util.List;

public interface GetByOn {
    String getName();

    String getSurname();
    List<Person> getChildren();
    List<Person> addParent();
    List<Person> addChild();
    List<Person> addPartner();
}