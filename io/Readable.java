package homeWork.io;

import java.io.IOException;

import homeWork.geotree.GeoTree;

public interface Readable {
    GeoTree read() throws IOException, ClassNotFoundException;
}