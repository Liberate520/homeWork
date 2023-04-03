import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable {
    public static transient List<Human> humans = new ArrayList<>();
    public HashMap<String, List<Human>> relations;

    public FamilyTree(Human human) {
        relations = human.allRelations();
    }

    public List<Human> getName(String name) {
        return getInfo(human -> human.name.equals(name));
    }

    public List<Human> getSurname(String surname) {
        return getInfo(human -> human.surname.equals(surname));
    }

    private List<Human> getInfo(Predicate<Human> byParam) {
        List<Human> human = new ArrayList<>();
        relations.forEach((key, value) -> {
            human.addAll(value.stream().filter(byParam)
                    .collect(Collectors.toList()));
        });
        return human;
    }

    public void save(FileWorker fileWorker, String filename) {
        fileWorker.save(this, filename);
    }

}