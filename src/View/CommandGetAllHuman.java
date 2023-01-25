package Seminars_OOP.HW_6.src.View;

public class CommandGetAllHuman implements Options {

    View view;

    public CommandGetAllHuman(View view) {

        this.view = view;
    }
    @Override
    public void execute() {
        view.GetAllHuman();


    }
    @Override
    public String description() {
        return "Выведем на печать весь список";
    }
}


