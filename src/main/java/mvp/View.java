package mvp;

import ui.ConsoleView;
import ui.UserInteraction;

public class View {
    private UserInteraction userInteraction = new ConsoleView();

    void setPresenter(Presenter presenter) {
        userInteraction.setPresenter(presenter);
    }

    public void start() {
        userInteraction.start();
    }
}
