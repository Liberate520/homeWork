package ui.Commands;

import ui.View;

import java.io.IOException;

public class SaveTree implements Command {
    public View view;
    public SaveTree(View view){
        this.view=view;
    }

    @Override
    public String getDescription() {
        return "сохранить дерево:";
    }

    @Override
    public void execute() throws IOException {
        view.SaveTree();
    }
}
