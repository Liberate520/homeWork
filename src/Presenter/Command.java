package src.Presenter;
import src.UI.View;


public abstract class Command implements Option {
    private Presenter presenter;

    public Command(Presenter presenter) {
        this.presenter = presenter;
    }

    public View getView(View view) {
        return view;
    }
}
