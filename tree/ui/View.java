package ui;

import java.util.List;

import presenter.Presenter;
import ui.Commands.Command;

public interface View {

    void printMenu(List<Command> commList);

    void start();

    void setPresenter(Presenter presenter);
}
