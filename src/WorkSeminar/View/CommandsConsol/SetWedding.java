package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SetWedding extends Commands{

    public SetWedding(View view){
        super("Связать узами ", view);
    }
    public void execute() {
        getView().setWedding();
    }
}
