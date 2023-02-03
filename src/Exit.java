public class Exit implements Option{
    View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.exit();
    }

    @Override
    public String discription() {
        return "выйти из меню";
    }
}
