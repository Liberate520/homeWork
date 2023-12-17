package Family_Tree.view.Commands;

import Family_Tree.view.View;

public class Finish extends Command{

    public Finish(View view) {
        super("Закончить работу", view);
    }

    public void execute(){
        getView().finish();
    }
}
