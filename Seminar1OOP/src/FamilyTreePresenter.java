
import java.io.IOException;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeModel model;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeModel model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void addHuman(Human human) {
        model.addHuman(human);
    }

    public Human getHumanByName(String name) {
        List<Human> humans = model.getHumanByName(name);
        if (!humans.isEmpty()) {
            return humans.get(0);
        }
        return null;
    }

    public List<Human> getAllHuman() {
        return model.getAllHuman();
    }

    public void sortByName() {
        model.sortByName();
    }

    public void saveToFile(String fileName) throws IOException {
        model.saveToFile(fileName);
    }

    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        model.loadFromFile(fileName);
    }
}