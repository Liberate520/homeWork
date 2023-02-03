public class FindHuman implements Option{
    View view;

    public FindHuman(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.findHuman();
    }

    @Override
    public String discription() {
        return "найти человека";
    }
}
