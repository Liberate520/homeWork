import java.util.List;

interface ParentInterface extends Person {
    List<Person> getChildren();
    void addChild(Person child);
    }
