import java.io.IOException;

import Storage.FileStorage;
import Storage.Storage;

public class Main {
    public static void main(String[] args) throws IOException {
        Storage storage = new FileStorage();
        Model model = new Model(storage);
        View view = new View();
        Presenter presenter = new Presenter(view, model);
        model.start();
    }
}
