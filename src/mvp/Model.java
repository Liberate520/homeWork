package mvp;

import storage.FileStorage;
import storage.Storage;

public class Model {
    private Storage storage = new FileStorage();

    public Model() {
    }

    public String readData() {
        return storage.read();
    }

    public void writeData(String userString) {
        storage.save(userString);
    }
}
