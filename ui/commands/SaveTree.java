package ui.commands;

import ui.View;

public class SaveTree implements Command{
    
    private View view;


    public SaveTree(View view) {
           this.view = view;
       }
    
   
       @Override
       public void execute() {
           view.saveTree();
   
       }

       @Override
       public String description() {
          
           return "Save Tree";
       }
}
