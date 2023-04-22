package service.FileHandlers;

import units.Unit;

import java.io.IOException;

public interface Writable {
    void save(Object obj, String path) throws IOException;
}
