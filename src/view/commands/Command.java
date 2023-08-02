package view.commands;

import presenter.Presenter;

public interface Command {
    String description = null;
    public void start(Presenter presenter);
    public String getDescription();
}
