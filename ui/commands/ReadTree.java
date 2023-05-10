package ui.commands;

import ui.View;

public class ReadTree  implements Command{
    
    private View view;


    public ReadTree(View view) {
           this.view = view;
       }
    
   
       @Override
       public void execute() {
           view.readTree();
   
       }
       @Override
       public String description() {
          
           return "Read Tree";
       }
}
