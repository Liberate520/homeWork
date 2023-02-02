public class SortByYear<E extends Members> implements TreeOptions {

    View view;

    private Tree tree;

    public SortByYear(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "5 - Cортировка по году";
    }

    @Override
    public void execute() {
        view.sortByYear();
    }

}
