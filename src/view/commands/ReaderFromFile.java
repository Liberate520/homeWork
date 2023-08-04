package view.commands;

import presenter.Presenter;

public class ReaderFromFile implements Command{
    String description = "Read tree from file";

    public void start(Presenter presenter){
        presenter.readFromFile();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
