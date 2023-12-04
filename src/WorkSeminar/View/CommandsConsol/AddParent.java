package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class AddParent extends Commands{

    public AddParent(View view){
        super("Указать родителей ребёнку ", view);
    }
    public void execute() {
        getView().addParent();
    }
}
