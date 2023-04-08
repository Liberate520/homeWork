package homeWork.io;

import java.io.IOException;

import homeWork.geotree.GeoTree;

public interface Writable {
    void write(GeoTree geo) throws IOException;
}