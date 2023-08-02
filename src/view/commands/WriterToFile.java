package view.commands;

import presenter.Presenter;
import view.Text;

public class WriterToFile implements Command{
    String description = "Write tree to file";

    public void start(Presenter presenter){
        presenter.writeToFile();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
