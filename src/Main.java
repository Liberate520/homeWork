import model.ModelNotepad;
import presenter.PresenterNotepad;
import view.ViewNotepad;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ModelNotepad modelNotepad = new ModelNotepad();
        ViewNotepad viewNotepad = new ViewNotepad();
        PresenterNotepad presenterNotepad = new PresenterNotepad(viewNotepad, modelNotepad);
        viewNotepad.menu();
    }
}
