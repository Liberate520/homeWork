package Seminars_OOP.HW_5.src.View;

public class CommandGetHumanByName implements Options {
    View view;

    public CommandGetHumanByName(View view){

        this.view = view;
    }
    @Override
    public void execute() {
        view.HumanByName();

    }
    @Override
    public String description() {
        return "Найдем человека по имени";
    }
}


