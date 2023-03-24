package mvp;

public class Presenter {
    private View view;
    private Model model;
    private boolean keepRunning;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        keepRunning = true;
    }

    public void start() {
        while (keepRunning) {
            String mainMenuItem = view.mainMenuItem();
            if (mainMenuItem.equals("1")) {
                view.print(model.readData());
            } else if (mainMenuItem.equals("2")) {
                String note = view.note();
                model.writeData(note);
            } else if (mainMenuItem.equals("3")) {
                keepRunning = false;
                view.print("Работа завершена");
            }
        }
    }
}
