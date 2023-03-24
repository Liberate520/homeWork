package mvp;

import storage.Storage;

public class Model {
    private Storage storage;

    public Model(Storage storage) {
        this.storage = storage;
    }

    public String readData() {
        return storage.read();
    }

    public void writeData(String userString) {
        storage.save(userString);
    }
}
