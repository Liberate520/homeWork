package notebook.storage;

import notebook.Service;

public interface Storage {
    Service read();
    void write(Service service);
}
