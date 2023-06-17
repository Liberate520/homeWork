package Views.Commands;

import Views.Executable;

public class CommandShow implements Command{

    private Executable view;
    public CommandShow(Executable view){
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Show";
    }

    @Override
    public void execute() {
        view.get();
    }    
}
