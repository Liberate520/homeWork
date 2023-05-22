package familyTree.ui.commands;
import familyTree.ui.View;

public class finish implements Command {
    private View view;

    public finish(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Close App";
    }

    @Override
    public void execute() {
        view.finish();
    }
}