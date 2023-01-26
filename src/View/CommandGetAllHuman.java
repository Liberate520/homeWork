package Seminars_OOP.HW_7.src.View;

public class CommandGetAllHuman implements Options {

    View view;

    public CommandGetAllHuman(View view) {

        this.view = view;
    }

    @Override
    public void execute() {
        view.getAllHuman();


    }
    @Override
    public String description() {
        return "Выведем на печать весь список (не утруждая себя сортировкой).";
    }
}


