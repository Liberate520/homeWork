package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class CreateTree extends Commands{

   public CreateTree(View view){
       super("Создать тестовое Древо ", view);
   }
    public void execute() {
        getView().createTree();
    }
}
