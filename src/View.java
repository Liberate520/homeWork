import java.io.FileNotFoundException;
import java.io.IOException;

public interface View {
    void setPresenter(Presenter presenter);
    void start() throws NumberFormatException, FileNotFoundException, IOException;
    void print(String text);
}
