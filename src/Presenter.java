import java.io.IOException;
import java.util.List;

public class Presenter {
    private Tree<Human> tree;
    private FileHandler fileHandler;
    private Presenter presenter;

    public Presenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public List<Human> getHumans() {
        List<Human> humans = tree.getHumanlist();
        return humans;
    }

    public void comandSortByName() {
        tree.sortByName();
    }

    public void comandSortByBirth() {
        tree.sortByBirth();
    }

    public void comandSave() throws IOException {
        fileHandler.save(tree.getHumanlist());
    }
}
