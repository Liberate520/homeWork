public class GetChildrens<E extends Members> implements TreeOptions {

    View view;

    private Tree tree;

    public GetChildrens(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "2 - Показать детей";
    }

    @Override
    public void execute() {
        view.getChildrens(null);
    }

}
