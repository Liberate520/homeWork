package homeWork.src.view.commands;

import homeWork.src.view.View;

public class Exit extends Command{

    public Exit(View view) {
        super("Exit", view);
    }

    public void execute(){
        getView().exit();
    }
}
