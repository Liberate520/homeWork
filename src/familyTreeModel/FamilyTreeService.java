package familyTreeModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class FamilyTreeService implements Service {

    @Override
    public String get(HashMap<String, String> request)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        FileHandler FileHandler = new FileHandler();
        FamilyTree<Human> familyTree = new FamilyTree<Human>();
        familyTree = FileHandler.download();

        if (request.get("selector").equals("full")) {
            return familyTree.toString();
        } else if (request.get("selector").equals("search")) {
            Human human = familyTree.get(request.get("name"), request.get("surname"));
            if (human != null) {
                return human.toString();
            } else {
                return "Не найден.";
            }
        } else if (request.get("selector").equals("add")) {
            Sex sex = Sex.Male;
            if (request.get("sex").equals(Sex.Female.toString())) {
                sex = Sex.Female;
            }
            Human human = new Human(request.get("name"), request.get("surname"), sex,
                    Integer.parseInt(request.get("startDate")), Integer.parseInt(request.get("endDate")),
                    familyTree.get(request.get("nameMother")));
            familyTree.add(human);
            FileHandler.save(familyTree);
            return "Успешно добавлен: " + human.toString();
        } else {
            return "Не верный параметр";
        }
    }
}
