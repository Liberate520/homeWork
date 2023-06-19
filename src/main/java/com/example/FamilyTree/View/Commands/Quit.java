package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.View;

public class Quit implements Command {
    private View view;

    public Quit(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        view.quit();
    }
}