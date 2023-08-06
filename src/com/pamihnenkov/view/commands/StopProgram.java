package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.View;

public class StopProgram extends Command{
    public StopProgram(View view) {
        super(view, "Завершение работы");
    }

    @Override
    public void execute() {
        view.finish();
    }
}
