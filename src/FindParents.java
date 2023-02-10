public class FindParents implements Option{
    View view;

    public FindParents(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.findParents();
    }

    @Override
    public String discription() {
        return "найти родителей";
    }
}
