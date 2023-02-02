public class SortByName<E extends Members> implements TreeOptions {

    View view;

    private Tree tree;

    public SortByName(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "4 - Сортировка по имени";
    }

    @Override
    public void execute() {
        view.sortByName();
    }

}
