package ui;

public class StartCommand implements Command {

    private View view;

    public StartCommand(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.start();

    }
}
