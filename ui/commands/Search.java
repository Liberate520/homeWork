package ui.commands;

import ui.View;

public class Search implements Command{
    
    private View view;


 public Search(View view) {
        this.view = view;
    }
 

    @Override
    public void execute() {
        view.search();;

    }

    @Override
    public String description() {
       
        return "View All";
    }
}
