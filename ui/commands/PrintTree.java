package ui.commands;

import ui.View;

public class PrintTree implements Command{
    private View view;


    public PrintTree(View view) {
           this.view = view;
       }
    
   
       @Override
       public void execute() {
           view.printTree();
   
       }

       @Override
       public String description() {
          
           return "Print Tree";
       }
}
