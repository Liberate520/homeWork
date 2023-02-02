
public class Presenter {
    View view;
    Model model;
    Tree tree;

    public Presenter(View view, Tree tree) {
        this.view = view;
        this.tree = tree;
    }

    public void getTree(Tree tree) {
        Model model = new Model<>(this, tree);
        model.getTree(tree);
    }

    public void getChildrens(String surname, String name) {
        Model model = new Model<>(this, tree);
        model.getChildrens(surname, name);
    }

    public void addHumanEnter(String surname, String name, int yearBorn, int yearDead, String sex) {
        Model model = new Model<>(this, tree);
        model.addHumanEnter(surname, name, yearBorn, yearDead, sex);
    }

    public void sortBySurname(Tree tree) {
        Model model = new Model<>(this, tree);
        model.sortBySurname();
    }

    public void sortByYear(Tree tree) {
        Model model = new Model<>(this, tree);
        model.sortByDate();
    }

}
