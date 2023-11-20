package View.Commands;

import View.View;

public class Finish extends Command{
    public Finish(View view) {
        super(view, "Завершить");
    }

    @Override
    public void execute() {
        getView().finish();
    }
}
