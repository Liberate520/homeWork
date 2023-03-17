package familyTreeModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class FamilyTreeService implements Service {
    Handler handler;
    FamilyTree familyTree;

    public FamilyTreeService(Handler handler) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.handler = handler;
        this.familyTree = (FamilyTree) handler.download();
    }

    @Override
    public String showList() {
        return familyTree.toString();
    }

    @Override
    public String Search(Map<String, String> data) {
        return convertPersonStringSearch((Human) familyTree.get(data.get("name"), data.get("surname")));
    }

    private String convertPersonStringSearch(Human person) {
        if (person != null) {
            return person.toString();
        } else {
            return "Пользователь не найден.";
        }
    }

    @Override
    public String getChildren(Map<String, String> data) {
        return convertPersonStringChildren((Human) familyTree.get(data.get("name"), data.get("surname")));
    }

    private String convertPersonStringChildren(Human person) {
        if (person != null) {
            return "Дети пользователя " + person.getName() + " " + person.getSurname() + ": "
                    + person.getChildren().toString();
        } else {
            return "Пользователь не найден.";
        }
    }

    @Override
    public String Add(Map<String, String> data) throws FileNotFoundException, IOException, ClassNotFoundException {
        Sex sex = data.get("sex").equals(Sex.Female.toString()) ? Sex.Female : Sex.Male;
        Human human = new Human(data.get("name"), data.get("surname"), sex, Integer.parseInt(data.get("startDate")),
                Integer.parseInt(data.get("endDate")), familyTree.get(data.get("nameMother")));
        familyTree.add(human);
        handler.save(familyTree);
        return "Успешно добавлен: " + human.toString();
    }
}
