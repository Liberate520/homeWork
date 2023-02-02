public class AddHuman<E extends Members> implements TreeOptions {
    View view;

    private Tree tree;

    public AddHuman(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "3 - Добавить человека";
    }

    @Override
    public void execute() {
        view.addHuman(null);
    }

}
