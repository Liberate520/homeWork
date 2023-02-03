public class AddHuman implements Option{
    View view;
    Main main;

    public AddHuman(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.addHuman();
    }



    @Override
    public String discription() {
        return "добавить человека";
    }
}
