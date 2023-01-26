package Seminars_OOP.HW_7.src.View;

public class CommandGetHumanByName implements Options {
    View view;

    public CommandGetHumanByName(View view){
        this.view = view;
    }

    @Override
    public void execute() {

        view.getHumanByName();
    }

//    }
    @Override
    public String description() {

        return "Найдем человека по имени.";
    }

//    @Override
//    public String toString() {
//        return get
//    }
}


