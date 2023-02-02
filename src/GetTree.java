
public class GetTree<E extends Members> implements TreeOptions {

    View view;

    private Tree tree;

    public GetTree(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "1 - Вывести дерево";
    }

    @Override
    public void execute() {
        view.getTree();
    }

}
