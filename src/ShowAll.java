public class ShowAll implements Option{
    View view;

    public ShowAll(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showAll();
    }

    @Override
    public String discription() {
        return "показать всех";
    }
}
