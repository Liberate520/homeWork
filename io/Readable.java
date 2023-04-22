package io;

import geotree.GeoTree;

import java.io.IOException;

public interface Readable {
    GeoTree read() throws IOException, ClassNotFoundException;
}